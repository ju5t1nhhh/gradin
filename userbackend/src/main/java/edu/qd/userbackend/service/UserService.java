package edu.qd.userbackend.service;

import edu.qd.userbackend.domain.UserDetail;
import edu.qd.userbackend.vo.RestResponse;

public interface UserService {

    RestResponse register(String id, String pwd, String email, String ecode);

    RestResponse modifyEmail(String newEmail, String emailCode);

    RestResponse modifyPwd(String oldPassword, String newPassword);

    RestResponse modifyDetail(UserDetail userDetail);

    RestResponse showPerson(String id);

    RestResponse detailPerson(long id);

}
