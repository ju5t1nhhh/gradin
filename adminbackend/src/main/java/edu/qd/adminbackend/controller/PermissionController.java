package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.domain.Permission;
import edu.qd.adminbackend.service.PermissionService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/add")
    @RequiresPermissions("perm:add")
    @ApiOperation("添加权限")
    public RestResponse addPerm(Permission permission) {
        return permissionService.addPerm(permission);
    }

    @PostMapping("/del/{id://d+}")
    @RequiresPermissions("perm:del")
    @ApiOperation("删除权限")
    public RestResponse delPerm(@PathVariable int id) {
        return permissionService.delPerm(id);
    }

    @PostMapping("/mod")
    @RequiresPermissions("perm:mod")
    @ApiOperation("修改权限")
    public RestResponse modPerm(Permission permission) {
        return permissionService.modifyPerm(permission);
    }

    @PostMapping("/list")
    @RequiresPermissions("perm:list")
    @ApiOperation("查看权限列表")
    public RestResponse listPerm(Permission permission) {
        return permissionService.listPerm(permission);
    }

    @PostMapping("/role/{id://d+}")
    @RequiresPermissions("perm:list")
    @ApiOperation("查看角色权限列表")
    public RestResponse listPermByRole(@PathVariable int id) {
        return permissionService.listPermByRole(id);
    }

}
