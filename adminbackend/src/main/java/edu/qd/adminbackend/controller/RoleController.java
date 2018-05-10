package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.dao.RolePermissionDao;
import edu.qd.adminbackend.service.RoleService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePermissionDao rolePermissionDao;

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

    @PostMapping("/perm/{role}")
    @RequiresPermissions("role:mod")
    @ApiOperation("修改角色权限列表")
    public RestResponse modRoleToPerm(@PathVariable int role, @RequestBody String[] perms) {
        int[] permsNum = new int[]{1,5,6,9,11,15,16,18,19,21,22,23,24,26,27,29,30,34,35,38,39,43};
        List<Integer> permsNumList = new ArrayList<>();
        for ( String permName : perms ) {
            permsNumList.add(rolePermissionDao.getId(permName));
        }
        for ( int num : permsNum ) {
            permsNumList.add(num);
        }
        System.out.println(permsNumList);
        return roleService.modRoleToPerm( role, permsNumList );
    }


}
