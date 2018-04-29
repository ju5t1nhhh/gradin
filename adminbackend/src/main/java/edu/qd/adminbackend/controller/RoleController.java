package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.service.RoleService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add/{role}")
    @RequiresPermissions("role:add")
    @ApiOperation("添加角色")
    public RestResponse addRole(@PathVariable String role) {
        return roleService.addRole(role);
    }

    @PostMapping("/del/{role}")
    @RequiresPermissions("role:del")
    @ApiOperation("删除角色")
    public RestResponse delRole(@PathVariable String role) {
        return roleService.delRole(role);
    }

    @PostMapping("/list")
    @RequiresPermissions("role:list")
    @ApiOperation("查看角色列表")
    public RestResponse listRole() {
        return roleService.listRoles();
    }

    @PostMapping("/perm/{role://d+}")
    @RequiresPermissions("role:mod")
    @ApiOperation("修改角色权限列表")
    public RestResponse modRoleToPerm(@PathVariable int role, int[] perms) {
        return roleService.modRoleToPerm(role, perms);
    }


}
