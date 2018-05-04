package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Complaint;
import edu.qd.userbackend.domain.ComplaintPost;
import edu.qd.userbackend.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class ComplaintPostDaoTest {
    @Autowired
    private PostDao postDao;

    @Test
    public void selectById() throws Exception {
        Post post = new Post(1L,"sadasd","sdawe",12,new Timestamp(1321313));
        postDao.insertOne(post);
    }

    @Test
    public void selectByEmail() throws Exception {
    }

}