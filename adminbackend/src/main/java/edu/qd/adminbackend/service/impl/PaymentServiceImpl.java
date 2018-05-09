package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.dao.LogRecordDao;
import edu.qd.adminbackend.dao.PaymentDao;
import edu.qd.adminbackend.dao.UserDao;
import edu.qd.adminbackend.domain.Payment;
import edu.qd.adminbackend.domain.User;
import edu.qd.adminbackend.dto.PaymentDTO;
import edu.qd.adminbackend.service.PaymentService;
import edu.qd.adminbackend.util.LogRecordDaoUtil;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private LogRecordDao logRecordDao;

    @Override
    public RestResponse addPayment(Payment payment) {
        payment.setCreatime(new Timestamp(new Date().getTime()));
        int rows = paymentDao.insertOne(payment);
        if ( rows > 0 ) {
            LogRecordDaoUtil.insertLogRecord(logRecordDao, "新增支付信息:"+payment);
            return RestResponse.successWithMsg("新增支付信息成功");
        } else
            return RestResponse.errorWithMsg(1117,"新增支付信息失败");
    }

    @Override
    public RestResponse listPayment(PaymentDTO paymentDTO) {
        Payment payment = paymentDTO;
        int page = paymentDTO.getPage();
        int offset = ( page - 1 ) * 15;
        System.out.println(payment);
        System.out.println("page:"+page);
        Payment[] payments = paymentDao.selectByDTO(payment, offset, 15);
        return RestResponse.successWithData("查看支付信息列表成功", payments);
    }
}
