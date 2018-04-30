package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@SpringBootTest
@RunWith(SpringRunner.class)

public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void insertOne() throws Exception {
        User user = new User(1L,"jijiji","asdasd",2,"sdaad",1);
        userDao.insertOne(user);
    }


}