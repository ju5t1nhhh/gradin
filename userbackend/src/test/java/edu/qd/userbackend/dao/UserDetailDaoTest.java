package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Favorite;
import edu.qd.userbackend.domain.UserDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class UserDetailDaoTest {
    @Autowired
    private UserDetailDao userDetailDao;

    @Test
    public void selectById() throws Exception {
        UserDetail userDetail = new UserDetail(1L,"sdad","sdad","saweas","wdasd",'a',"hgygh");
        userDetailDao.insertOne(userDetail);
    }

    @Test
    public void selectByEmail() throws Exception {
    }

}