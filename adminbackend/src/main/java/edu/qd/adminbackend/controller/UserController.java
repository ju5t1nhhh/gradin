package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.domain.User;
import edu.qd.adminbackend.service.UserService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @RequiresPermissions("user:add")
    @ApiOperation("新增用户")
    public RestResponse addUser(@Valid User user) {
        return userService.addUser(user);
    }

    @PostMapping("/del")
    @RequiresPermissions("user:del")
    @ApiOperation("删除用户")
    public RestResponse delUser(User user) {
        return userService.delUser(user);
    }

    @PostMapping("/mod")
    @RequiresPermissions("user:mod")
    @ApiOperation("修改用户")
    public RestResponse modUser(@Valid User user) {
        return userService.modifyUser(user);
    }

    @PostMapping("/list")
    @RequiresPermissions("user:list")
    @ApiOperation("查看用户列表")
    public RestResponse listUser(User user, @RequestParam(defaultValue = "1") int page) {
        return userService.listUser(user, page);
    }

}
