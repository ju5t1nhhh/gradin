package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.Payment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
@SpringBootTest
@RunWith(SpringRunner.class)

public class PaymentDaoTest {
    @Autowired
    private PaymentDao paymentDao;

    @Test
    public void insertOne() throws Exception {
        Payment payment = new Payment("gjhgj",1L, 1,"sdasd",new Timestamp(546466 ));
        paymentDao.insertOne(payment);
    }

}