package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.PaymentDao;
import edu.qd.userbackend.dao.UserDao;
import edu.qd.userbackend.domain.Payment;
import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.service.PaymentService;
import edu.qd.userbackend.vo.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse getGins(String code) {
        Payment payment = new Payment();
        payment.setCode(code);
        Payment[] payments = paymentDao.selectByDTO(payment,0,1);
        if ( payments.length == 0 ) {
            return RestResponse.errorWithMsg(1801, "无效码，请关注Gradin公众号获取");
        } else {
            payment = payments[0];
            if ( payment.getStatus() == 0 ) {
                User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
                user = userDao.selectById(user.getId());
                user.setGins(user.getGins()+100);
                userDao.updateOne(user);
                payment.setStatus(1);
                payment.setUser(user.getAutoId());
                int rows = paymentDao.updateOne(payment);
                System.out.println("rows:"+rows);
                redisTemplate.opsForHash().put("user:"+user.getId(), "gins", String.valueOf(user.getGins()));
                return RestResponse.successWithMsg("验证成功");
            } else {
                return RestResponse.successWithMsg("码已被验证");
            }
        }
    }
}
