package edu.qd.userbackend.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendSimpleEmail() throws Exception {
        mailService.sendSimpleEmail("jiumam123@qq.com", "丢雷");
    }

}