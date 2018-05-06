package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.domain.Payment;
import edu.qd.adminbackend.service.PaymentService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    @RequiresPermissions("payment:add")
    @ApiOperation("新增支付订单")
    public RestResponse addPayment(Payment payment) {
        return paymentService.addPayment(payment);
    }

    @PostMapping("/list")
    @RequiresPermissions("payment:list")
    @ApiOperation("查看支付订单")
    public RestResponse listPayment(Payment payment, @RequestParam(defaultValue = "1") int page) {
        return paymentService.listPayment(payment,page);
    }

}
