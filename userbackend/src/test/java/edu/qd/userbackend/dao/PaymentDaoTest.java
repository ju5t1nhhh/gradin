package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Favorite;
import edu.qd.userbackend.domain.Payment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class PaymentDaoTest {
    @Autowired
    private PaymentDao paymentDao;

    @Test
    public void selectById() throws Exception {
        Payment payment = new Payment("sdasds",1L,112,"adasd",new Timestamp(131233));
        paymentDao.insertOne(payment);
    }

    @Test
    public void selectByEmail() throws Exception {
    }

}