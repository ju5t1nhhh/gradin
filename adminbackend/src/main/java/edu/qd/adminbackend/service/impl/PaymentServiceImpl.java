package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.domain.Payment;
import edu.qd.adminbackend.service.PaymentService;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public RestResponse addPayment(Payment payment) {
        return null;
    }

    @Override
    public RestResponse listPayment(Payment payment, int page) {
        return null;
    }
}
