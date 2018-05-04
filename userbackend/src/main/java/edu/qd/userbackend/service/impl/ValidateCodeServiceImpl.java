package edu.qd.userbackend.service.impl;

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
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse getEmailCode(String email) {
        Subject subject = SecurityUtils.getSubject();
        String ecode = String.valueOf((int)((Math.random()*9+1)*1000));
        Thread thread = new Thread(() -> {
            mailService.sendSimpleEmail(email,ecode);
        });
        thread.start();
        redisTemplate.opsForValue().set("ecode:"+subject.getSession().getId(),ecode,1, TimeUnit.HOURS);
        return RestResponse.successWithMsg("发送邮箱验证码成功");
    }

    @Override
    public boolean checkEmailCode(String code) {
        Subject subject = SecurityUtils.getSubject();
        String vcode = redisTemplate.opsForValue().get("ecode:"+subject.getSession().getId());
        return code == vcode;
    }
}
