package edu.qd.userbackend.service;

import edu.qd.userbackend.vo.RestResponse;

public interface MailService {

    RestResponse sendSimpleEmail(String to, String content);

}
