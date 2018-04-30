package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.domain.Admin;
import edu.qd.adminbackend.service.AdminService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    @RequiresPermissions("admin:add")
    @ApiOperation("添加管理员")
    public RestResponse addAdmin(@Valid Admin admin) {
        return adminService.addAdmin(admin);
    }

    @PostMapping("/del/{id}")
    @RequiresPermissions("admin:del")
    @ApiOperation("删除管理员")
    public RestResponse delAdmin(@PathVariable String id) {
        return adminService.delAdmin(id);
    }

    @PostMapping("/mod")
    @RequiresPermissions("admin:mod")
    @ApiOperation("修改管理员")
    public RestResponse modifyAdmin(@Valid Admin admin) {
        return adminService.modifyAdmin(admin);
    }

    @PostMapping("/list")
    @RequiresPermissions("admin:list")
    @ApiOperation("查看管理员列表")
    public RestResponse listAdmin(Admin admin) {
        return adminService.listAdmin(admin);
    }

}
