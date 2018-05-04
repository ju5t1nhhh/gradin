package edu.qd.userbackend.service;

import edu.qd.userbackend.vo.RestResponse;

public interface ValidateCodeService {

    RestResponse getEmailCode(String email);

    boolean checkEmailCode(String code);

}
