package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Favorite;
import edu.qd.userbackend.domain.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class TagDaoTest {
    @Autowired
    private TagDao tagDao;

    @Test
    public void selectById() throws Exception {
        Tag tag = new Tag("asdad",1L);
        tagDao.insertOne(tag);
    }

    @Test
    public void selectByEmail() throws Exception {
    }


}