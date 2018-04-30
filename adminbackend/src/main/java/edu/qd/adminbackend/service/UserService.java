package edu.qd.adminbackend.service;

import edu.qd.adminbackend.domain.User;
import edu.qd.adminbackend.vo.RestResponse;

public interface UserService {

    RestResponse addUser(User user);

    RestResponse delUser(User user);

    RestResponse modifyUser(User user);

    RestResponse listUser(User user, int page);

}
