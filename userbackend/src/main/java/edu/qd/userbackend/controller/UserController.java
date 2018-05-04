package edu.qd.userbackend.controller;

import edu.qd.userbackend.domain.UserDetail;
import edu.qd.userbackend.service.UserService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation("注册")
    public RestResponse register(String id, String pwd, String email, String ecode) {
        return userService.register(id, pwd, email, ecode);
    }

    @PostMapping("/modid")
    @ApiOperation("修改id")
    public RestResponse modId(String newId) {
        return userService.modifyId(newId);
    }

    @PostMapping("/modemail")
    @ApiOperation("修改Email")
    public RestResponse modEmail(String newEmail, String emailCode) {
        return userService.modifyEmail(newEmail, emailCode);
    }

    @PostMapping("/modpwd")
    @ApiOperation("修改密码")
    public RestResponse modPwd(String oldPwd, String newPwd) {
        return userService.modifyPwd(oldPwd, newPwd);
    }

    @PostMapping("/moddetail")
    @ApiOperation("修改详情页")
    public RestResponse modDetail(UserDetail userDetail) {
        return userService.modifyDetail(userDetail);
    }

    @PostMapping("/show/{id}")
    @ApiOperation("查看个人页面")
    public RestResponse showPerson(@PathVariable long id) {
        return userService.showPerson(id);
    }

    @PostMapping("/detail/{id}")
    @ApiOperation("查看个人详页")
    public RestResponse detailPerson(@PathVariable long id) {
        return null;
    }

}
