package edu.qd.adminbackend.service;

import edu.qd.adminbackend.domain.Payment;
import edu.qd.adminbackend.vo.RestResponse;

public interface PaymentService {

    RestResponse addPayment(Payment payment);

    RestResponse listPayment(Payment payment, int page);

}
