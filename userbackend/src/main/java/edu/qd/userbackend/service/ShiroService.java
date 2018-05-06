package edu.qd.userbackend.service;

import edu.qd.userbackend.vo.RestResponse;

public interface ShiroService {

    RestResponse login(String id, String password);

}
