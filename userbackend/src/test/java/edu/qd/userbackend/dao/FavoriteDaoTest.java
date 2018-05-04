package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Favorite;
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

public class FavoriteDaoTest {
    @Autowired
    private FavoriteDao favoriteDao;

    @Test
    public void selectById() throws Exception {
        Favorite favorite = new Favorite(1L,1L);
        favoriteDao.insertOne(favorite);
    }

    @Test
    public void selectByEmail() throws Exception {
    }

}