package edu.qd.userbackend.controller;

import edu.qd.userbackend.service.PaymentService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/code")
    @ApiOperation("兑换GINS")
    public RestResponse getGins(@RequestBody String code) {
        return paymentService.getGins(code);
    }
}
