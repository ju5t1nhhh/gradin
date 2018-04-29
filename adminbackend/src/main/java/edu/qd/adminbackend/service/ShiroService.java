package edu.qd.adminbackend.service;

import edu.qd.adminbackend.vo.RestResponse;

public interface ShiroService {

    RestResponse login(String id, String password);

}
