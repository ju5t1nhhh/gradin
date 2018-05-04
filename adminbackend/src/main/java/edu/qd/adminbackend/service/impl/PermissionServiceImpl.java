package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.dao.PermissionDao;
import edu.qd.adminbackend.dao.RolePermissionDao;
import edu.qd.adminbackend.domain.Permission;
import edu.qd.adminbackend.service.PermissionService;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    public RestResponse addPerm(Permission permission) {
        int rows = permissionDao.insertOne(permission);
        if ( rows > 0 ) {
            return RestResponse.successWithMsg("新增权限成功");
        } else {
            return RestResponse.errorWithMsg(1008,"新增权限失败");
        }
    }

    @Override
    public RestResponse delPerm(int id) {
        Permission permission = new Permission();
        permission.setId(id);
        int rows = permissionDao.deleteByDTO(permission);
        if ( rows > 0 ) {
            return RestResponse.successWithMsg("删除权限成功");
        } else {
            return RestResponse.errorWithMsg(1009,"删除权限失败");
        }
    }

    @Override
    public RestResponse modifyPerm(Permission permission) {
        int rows = permissionDao.updateOne(permission);
        if ( rows > 0 ) {
            return RestResponse.successWithMsg("修改权限成功");
        } else {
            return RestResponse.errorWithMsg(1010,"修改权限失败");
        }
    }

    @Override
    public RestResponse listPerm(Permission permission) {
        Permission[] perms = permissionDao.selectByDTO(permission,0,-1);
        return RestResponse.successWithData("查看权限列表成功", perms);
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
        return RestResponse.successWithData("查看角色的权限列表成功", permissionList.toArray());
    }
}
