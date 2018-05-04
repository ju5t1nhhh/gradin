package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Favorite;
import edu.qd.userbackend.domain.SensitiveWord;
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
    public void selectById() throws Exception {
        SensitiveWord sensitiveWord = new SensitiveWord(12,"sadw","asdwd");
        sensitiveWordDao.insertOne(sensitiveWord);
    }

    @Test
    public void selectByEmail() throws Exception {
    }

}