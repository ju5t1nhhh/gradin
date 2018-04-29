package edu.qd.adminbackend.service.impl;

import com.alibaba.fastjson.JSON;
import edu.qd.adminbackend.dao.PermissionDao;
import edu.qd.adminbackend.dao.RolePermissionDao;
import edu.qd.adminbackend.domain.Permission;
import edu.qd.adminbackend.service.PermissionService;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse addPerm(Permission permission) {
        int rows = permissionDao.insertOne(permission);
        if ( rows > 0 ) {
            redisTemplate.opsForList().rightPush("perms", JSON.toJSONString(permission));
            return RestResponse.successWithMsg("新增权限成功");
        } else {
            return RestResponse.errorWithMsg(1008,"新增权限失败");
        }
    }

    @Override
    public RestResponse delPerm(int id) {
        Permission permission = new Permission();
        permission.setId(id);
        permission = permissionDao.selectByDTO(permission,0,1)[0];
        int rows = permissionDao.deleteByDTO(permission);
        if ( rows > 0 ) {
            redisTemplate.opsForList().remove("perms", 1,JSON.toJSONString(permission));
            return RestResponse.successWithMsg("删除权限成功");
        } else {
            return RestResponse.errorWithMsg(1009,"删除权限失败");
        }
    }

    @Override
    public RestResponse modifyPerm(Permission permission) {
        Permission old = new Permission();
        permission.setId(permission.getId());
        old = permissionDao.selectByDTO(old,0,1)[0];
        int rows = permissionDao.updateOne(permission);
        if ( rows > 0 ) {
            redisTemplate.opsForList().remove("perms",1,JSON.toJSONString(old));
            redisTemplate.opsForList().rightPush("perms",JSON.toJSONString(permission));
            return RestResponse.successWithMsg("修改权限成功");
        } else {
            return RestResponse.errorWithMsg(1010,"修改权限失败");
        }
    }

    @Override
    public RestResponse listPerm(Permission permission) {
        RestResponse restResponse = null;
        List<String> permStrings = redisTemplate.opsForList().range("perms",0,-1);
        if ( permStrings.size() == 0 ) {
            Permission[] perms = permissionDao.selectByDTO(permission,0,-1);
            Thread thread = new Thread(() -> {
                for ( Permission perm : perms )
                    redisTemplate.opsForList().rightPush("perms",JSON.toJSONString(perm));
            });
            thread.start();
            restResponse = RestResponse.successWithData("查看权限列表成功",JSON.toJSONString(perms));
        } else {
            restResponse = RestResponse.successWithData("查看权限列表成功",JSON.toJSONString(permStrings));
        }
        return restResponse;
    }

    @Override
    public RestResponse listPermByRole(int role) {
        int[] perms = rolePermissionDao.selectPermByRole(role);
        List<Permission> permissionList = new LinkedList<>();
        Permission pi = new Permission();
        for ( int perm : perms ) {
            pi.setId(perm);
            permissionList.add( permissionDao.selectByDTO(pi,0,1)[0] );
        }
        return RestResponse.successWithData("查看角色的权限列表成功", JSON.toJSONString(permissionList));
    }
}
