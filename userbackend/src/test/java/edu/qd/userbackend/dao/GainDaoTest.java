package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Favorite;
import edu.qd.userbackend.domain.Gain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class GainDaoTest {
    @Autowired
    private GainDao gainDao;

    @Test
    public void selectById() throws Exception {
        Gain gain = new Gain(1L,1L,123);
        gainDao.insertOne(gain);
    }

    @Test
    public void selectByEmail() throws Exception {
    }

}