package edu.qd.adminbackend.service;

import edu.qd.adminbackend.domain.Admin;
import edu.qd.adminbackend.vo.RestResponse;

public interface AdminService {

    RestResponse addAdmin(Admin admin);

    RestResponse delAdmin(String id);

    RestResponse modifyAdmin(Admin admin);

    RestResponse listAdmin(Admin admin);

}
