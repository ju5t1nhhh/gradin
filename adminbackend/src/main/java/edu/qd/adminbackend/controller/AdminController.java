package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.dao.AdminDao;
import edu.qd.adminbackend.dao.RoleDao;
import edu.qd.adminbackend.domain.Admin;
import edu.qd.adminbackend.service.AdminService;
import edu.qd.adminbackend.shiro.UserInfo;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleDao roleDao;

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

    @PostMapping("/myinfo")
    @RequiresPermissions("admin:list")
    @ApiOperation("查看我的信息")
    public RestResponse myinfo() {
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Map map = new HashMap();
        int role = adminDao.getRole(userInfo.getUsername());
        map.put("loginId", userInfo.getUsername());
        map.put("role", ""+role);
        map.put("rolename", roleDao.getName(role));
        Admin admin = new Admin();
        return RestResponse.successWithData("查看成功", map);
    }



}
