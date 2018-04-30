package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.Admin;
import edu.qd.adminbackend.domain.SensitiveWord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class SensitiveWordDaoTest {
    @Autowired
    private SensitiveWordDao sensitiveWordDao;

    @Test
    public void insertOne() throws Exception {
        SensitiveWord sensitiveWord = new SensitiveWord(1,"jijiji","asdasd");
        sensitiveWordDao.insertOne(sensitiveWord);
    }

}