package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.util.PasswordUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void selectById() throws Exception {
        User user = new User("ju5t1n","ju5t1nhhh@163.com",1,"hst0316",100);
        user.setPwd(PasswordUtil.encryptPassword(null,user.getPwd()));
        userDao.insertOne(user);
    }

    @Test
    public void selectByEmail() throws Exception {
    }

}