package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentDaoTest {

    @Autowired
    private CommentDao commentDao;

    @Test
    public void selectById() throws Exception {
        Comment comment = new Comment(1L,1,1L,"adssd","hst0316",new Timestamp(12312322));
        commentDao.insertOne(comment);
    }

    @Test
    public void selectByEmail() throws Exception {
    }

}