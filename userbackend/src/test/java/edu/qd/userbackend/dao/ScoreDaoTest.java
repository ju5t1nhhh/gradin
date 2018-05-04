package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Comment;
import edu.qd.userbackend.domain.Score;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class ScoreDaoTest {
    @Autowired
    private ScoreDao scoreDao;

    @Test
    public void selectById() throws Exception {
        Score score = new Score(1L,1l,12);
        scoreDao.insertOne(score);
    }

    @Test
    public void selectByEmail() throws Exception {
    }

}