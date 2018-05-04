package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.service.MailService;
import edu.qd.userbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public RestResponse sendSimpleEmail(String to, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject("Gradin - 邮箱验证码");
        mailMessage.setText("你的验证码是" + content);
        RestResponse restResponse = null;
        try {
            mailSender.send(mailMessage);
            restResponse = RestResponse.successWithMsg("发送邮箱验证码成功");
        } catch (Exception e) {
            restResponse = RestResponse.errorWithMsg(1200, "发送邮箱验证码失败");
        }
        return restResponse;
    }
}
