package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Favorite;
import edu.qd.userbackend.domain.Likes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class LikesDaoTest {
    @Autowired
    private LikesDao likesDao;

    @Test
    public void selectById() throws Exception {
        Likes likes = new Likes(1L,123,1L);
        likesDao.insertOne(likes);
    }

    @Test
    public void selectByEmail() throws Exception {
    }

}