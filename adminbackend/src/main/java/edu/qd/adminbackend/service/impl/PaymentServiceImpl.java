package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.dao.PaymentDao;
import edu.qd.adminbackend.dao.UserDao;
import edu.qd.adminbackend.domain.Payment;
import edu.qd.adminbackend.domain.User;
import edu.qd.adminbackend.service.PaymentService;
import edu.qd.adminbackend.util.LogRecordDaoUtil;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private UserDao userDao;

    @Override
    public RestResponse addPayment(Payment payment) {
        User user = new User();
        user.setAutoid(payment.getUser());
        user = userDao.selectByDTO(user,0,1)[0];
        user.setGins(user.getGins()+10);
        int rowsA = paymentDao.insertOne(payment);
        int rowsB = userDao.updateOne(user);
        if ( rowsA > 0 && rowsB > 0 ) {
            LogRecordDaoUtil.insertLogRecord("新增支付信息:"+payment);
            return RestResponse.successWithMsg("新增支付信息成功");
        } else
            return RestResponse.errorWithMsg(1117,"新增支付信息失败");
    }

    @Override
    public RestResponse listPayment(Payment payment, int page) {
        int offset = ( page - 1 ) * 15;
        Payment[] payments = paymentDao.selectByDTO(payment, offset, 15);
        return RestResponse.successWithData("查看支付信息列表成功", payments);
    }
}
