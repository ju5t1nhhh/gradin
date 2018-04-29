package edu.qd.adminbackend.service.impl;

import com.alibaba.fastjson.JSON;
import edu.qd.adminbackend.dao.RoleDao;
import edu.qd.adminbackend.dao.RolePermissionDao;
import edu.qd.adminbackend.domain.Role;
import edu.qd.adminbackend.service.RoleService;
import edu.qd.adminbackend.util.ArrayToListUtil;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse addRole(String role) {
        Role instants = new Role();
        instants.setName(role);
        int rows = roleDao.insertOne(instants);
        if ( rows > 0 ) {
            redisTemplate.opsForList().rightPush("roles", JSON.toJSONString(instants));
            return RestResponse.successWithMsg("添加角色成功");
        } else {
            return RestResponse.errorWithMsg(1006, "添加角色失败");
        }
    }

    @Override
    public RestResponse delRole(String role) {
        Role instants = new Role();
        instants.setName(role);
        Role rm = roleDao.selectByDTO(instants,0,1)[0];
        int rows = roleDao.deleteByDTO(instants);
        if ( rows > 0 ) {
            redisTemplate.opsForList().remove("roles",1, JSON.toJSONString(rm));
            return RestResponse.successWithMsg("删除角色" + role + "成功");
        } else {
            return RestResponse.errorWithMsg(1007, "删除角色" + role + "失败");
        }
    }

    @Override
    public RestResponse listRoles() {
        RestResponse restResponse = null;
        List<String> roleStrings = redisTemplate.opsForList().range("roles",0,-1);
        if ( roleStrings.size() == 0 ) {
            Role[] roles = roleDao.selectByDTO(null, 0, -1);
            Thread thread = new Thread(() -> {
                for ( Role role: roles )
                    redisTemplate.opsForList().rightPush("roles",JSON.toJSONString(role));
            });
            thread.start();
            restResponse = RestResponse.successWithData("查看角色成功", JSON.toJSONString(roles));
        } else {
            restResponse = RestResponse.successWithData("查看角色成功", JSON.toJSONString(roleStrings));
        }
        return restResponse;
    }

    @Override
    @Transactional
    public RestResponse modRoleToPerm(int role, int[] perms) {
        int[] oldPerms = rolePermissionDao.selectPermByRole(role);
        List<Integer> removeList = ArrayToListUtil.listARemoveListB(oldPerms, perms);
        List<Integer> addList = ArrayToListUtil.listARemoveListB(perms,oldPerms);
        int delNum = 0, addNum = 0;
        for ( int perm : removeList )
            delNum += rolePermissionDao.deleteOne(role, perm);
        for ( int perm : addList )
            addNum += rolePermissionDao.insertOne(role, perm);
        return RestResponse.successWithMsg("成功给角色添加" + addNum + "项权限，移除" + delNum + "项权限" );
    }

}
