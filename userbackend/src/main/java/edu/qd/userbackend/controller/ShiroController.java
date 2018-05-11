package edu.qd.userbackend.controller;

import edu.qd.userbackend.dto.LoginDTO;
import edu.qd.userbackend.service.ShiroService;
import edu.qd.userbackend.vo.RestResponse;
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
    public RestResponse login(@RequestBody LoginDTO loginDTO) {
        String id = loginDTO.getId();
        String password = loginDTO.getPassword();
        return shiroService.login(id, password);
    }

    @GetMapping({"/unauth","/302"})
    @ApiOperation("返回未授权信息")
    public RestResponse unauth() {
        return RestResponse.errorWithMsg(1002, "请登录");
    }

}
