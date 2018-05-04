package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Favorite;
import edu.qd.userbackend.domain.Follow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class FollowDaoTest {
    @Autowired
    private FollowDao followDao;

    @Test
    public void selectById() throws Exception {
        Follow follow = new Follow(1L,1L);
        followDao.insertOne(follow);
    }

    @Test
    public void selectByEmail() throws Exception {
    }

}