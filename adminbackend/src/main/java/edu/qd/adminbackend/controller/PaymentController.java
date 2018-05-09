package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.domain.Payment;
import edu.qd.adminbackend.dto.PaymentDTO;
import edu.qd.adminbackend.service.PaymentService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    @RequiresPermissions("payment:add")
    @ApiOperation("新增支付订单")
    public RestResponse addPayment(@RequestBody Payment payment) {
        return paymentService.addPayment(payment);
    }

    @PostMapping("/list")
    @RequiresPermissions("payment:list")
    @ApiOperation("查看支付订单")
    public RestResponse listPayment(@RequestBody PaymentDTO paymentDTO) {
        paymentDTO.setWechat(null);
        if ( paymentDTO.getPage() == 0 )
            paymentDTO.setPage(1);
        return paymentService.listPayment(paymentDTO);
    }

}
