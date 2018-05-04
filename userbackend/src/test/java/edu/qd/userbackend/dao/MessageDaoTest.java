package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Favorite;
import edu.qd.userbackend.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class MessageDaoTest {
    @Autowired
    private MessageDao messageDao;

    @Test
    public void selectById() throws Exception {
        Message message = new Message(1L,"sadasd","asdaws",112,new Timestamp(23123133));
        messageDao.insertOne(message);
    }

    @Test
    public void selectByEmail() throws Exception {
    }


}