package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.domain.Admin;
import edu.qd.adminbackend.service.ShiroService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiroController {

    @Autowired
    private ShiroService shiroService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public RestResponse login(@RequestBody Admin admin) {
        System.out.println(admin);
        return shiroService.login(admin.getLoginId(), admin.getPwd());
    }

    @GetMapping({"/unauth","/302"})
    @ApiOperation("返回未授权信息")
    public RestResponse unauth(String word) {
        return RestResponse.errorWithMsg(1002, "请登录");
    }
}
