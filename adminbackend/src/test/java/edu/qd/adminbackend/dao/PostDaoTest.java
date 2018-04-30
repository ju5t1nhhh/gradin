package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.Admin;
import edu.qd.adminbackend.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class PostDaoTest {
    @Autowired
    private PostDao postDao;

    @Test
    public void insertOne() throws Exception {
        Post post = new Post(1L,1L,"jiji","asdasd",2,new Timestamp(868786868));
        postDao.insertOne(post);
    }



}