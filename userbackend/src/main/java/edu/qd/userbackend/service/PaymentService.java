package edu.qd.userbackend.service;

import edu.qd.userbackend.vo.RestResponse;

public interface PaymentService {

    RestResponse getGins(String code);

}
