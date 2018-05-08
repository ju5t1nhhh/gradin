package edu.qd.adminbackend.service;

import edu.qd.adminbackend.domain.Payment;
import edu.qd.adminbackend.dto.PaymentDTO;
import edu.qd.adminbackend.vo.RestResponse;

public interface PaymentService {

    RestResponse addPayment(Payment payment);

    RestResponse listPayment(PaymentDTO paymentDTO);

}
