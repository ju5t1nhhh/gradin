package edu.qd.userbackend.controller;

import edu.qd.userbackend.service.ShiroService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiroController {

    @Autowired
    private ShiroService shiroService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public RestResponse login(String id, String password, String valiCode) {
        return shiroService.login(id, password, valiCode);
    }

    @GetMapping({"/unauth","/302"})
    @ApiOperation("返回未授权信息")
    public RestResponse unauth() {
        return RestResponse.errorWithMsg(1002, "请登录");
    }

    @GetMapping({"/test"})
    public RestResponse test() {
        return RestResponse.successWithMsg("fuck you");
    }

}
