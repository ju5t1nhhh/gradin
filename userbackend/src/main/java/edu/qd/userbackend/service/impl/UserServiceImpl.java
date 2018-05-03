package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.UserDao;
import edu.qd.userbackend.domain.UserDetail;
import edu.qd.userbackend.service.UserService;
import edu.qd.userbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse modifyId(String id) {
        return null;
    }

    @Override
    public RestResponse modifyEmail(String newEmail, String emailCode) {
        return null;
    }

    @Override
    public RestResponse modifyPwd(String oldPassword, String newPassword) {
        return null;
    }

    @Override
    public RestResponse modifyDetail(UserDetail userDetail) {
        return null;
    }
}
