package edu.qd.userbackend.controller;

import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.domain.UserDetail;
import edu.qd.userbackend.dto.ModEmailDTO;
import edu.qd.userbackend.dto.ModPwdDTO;
import edu.qd.userbackend.dto.RegisterDTO;
import edu.qd.userbackend.service.UserService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/checkid/{id}")
    @ApiOperation("检查用户名")
    public RestResponse checkid(@PathVariable String id) {
        return userService.checkId(id);
    }

    @PostMapping("/checkemail")
    @ApiOperation("检查邮箱")
    public RestResponse checkemail(@RequestBody String email) {
        return userService.checkEmail(email);
    }

    @PostMapping("/register")
    @ApiOperation("注册")
    public RestResponse register(@RequestBody RegisterDTO registerDTO) {
        String id = registerDTO.getId();
        String pwd = registerDTO.getPwd();
        String email = registerDTO.getEmail();
        return userService.register(id, pwd, email);
    }

    @PostMapping("/modemail")
    @ApiOperation("修改Email")
    public RestResponse modEmail(@RequestBody ModEmailDTO modEmailDTO) {
        String newEmail = modEmailDTO.getNewEmail();
        String emailCode = modEmailDTO.getEmailCode();
        return userService.modifyEmail(newEmail, emailCode);
    }

    @PostMapping("/modpwd")
    @ApiOperation("修改密码")
    public RestResponse modPwd(@RequestBody ModPwdDTO pwdDTO) {
        String oldPwd = pwdDTO.getOldPwd();
        String newPwd = pwdDTO.getNewPwd();
        return userService.modifyPwd(oldPwd, newPwd);
    }

    @PostMapping("/moddetail")
    @ApiOperation("修改详情页")
    public RestResponse modDetail(@RequestBody UserDetail userDetail) {
        return userService.modifyDetail(userDetail);
    }

    @PostMapping("/show/{id}")
    @ApiOperation("查看个人页面")
    public RestResponse showPerson(@PathVariable String id) {
        return userService.showPerson(id);
    }

    @PostMapping("/detail/{id}")
    @ApiOperation("查看个人详页")
    public RestResponse detailPerson(@PathVariable long id) {
        return userService.detailPerson(id);
    }

    @PostMapping("/my")
    @ApiOperation("查看我的信息")
    public RestResponse my() {
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        return RestResponse.successWithData("查看成功", user);
    }

}
