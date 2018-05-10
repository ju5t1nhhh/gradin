package edu.qd.userbackend.controller;

import edu.qd.userbackend.service.ValidateCodeService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code")
public class ValidateCodeController {

    @Autowired
    private ValidateCodeService validateCodeService;

    @PostMapping("/email")
    @ApiOperation("邮箱验证码")
    public RestResponse getEmailCode(@RequestBody String email) {
        return validateCodeService.getEmailCode(email);
    }

}
