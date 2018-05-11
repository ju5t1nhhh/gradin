package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.UserDao;
import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.service.MailService;
import edu.qd.userbackend.service.ValidateCodeService;
import edu.qd.userbackend.vo.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {

    @Autowired
    private MailService mailService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse getEmailCode(String email) {
        int count = userDao.emailExists(email);
        System.out.println("count:"+count);
        if ( count > 0 )
            return RestResponse.errorWithMsg(1400, "邮箱已被注册");
        Subject subject = SecurityUtils.getSubject();
        String ecode = String.valueOf((int)((Math.random()*9+1)*1000));
        System.out.println(email+":"+ecode);
        mailService.sendSimpleEmail(email,ecode);
        redisTemplate.opsForValue().set("ecode:"+subject.getSession().getId(),ecode,1, TimeUnit.HOURS);
        return RestResponse.successWithMsg("发送邮箱验证码成功");
    }

    @Override
    public boolean checkEmailCode(String code) {
        Subject subject = SecurityUtils.getSubject();
        String vcode = redisTemplate.opsForValue().get("ecode:"+subject.getSession().getId());
        System.out.println(" code  - "+"ecode:"+subject.getSession().getId());
        return code.equals(vcode);
    }
}
