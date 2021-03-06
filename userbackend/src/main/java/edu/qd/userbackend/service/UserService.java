package edu.qd.userbackend.service;

import edu.qd.userbackend.domain.UserDetail;
import edu.qd.userbackend.vo.RestResponse;

public interface UserService {

    RestResponse register(String id, String pwd, String email);

    RestResponse modifyEmail(String newEmail, String emailCode);

    RestResponse modifyPwd(String oldPassword, String newPassword);

    RestResponse modifyDetail(UserDetail userDetail);

    RestResponse showPerson(String id);

    RestResponse detailPerson();

    RestResponse checkId(String id);

    RestResponse checkEmail(String email);

}
