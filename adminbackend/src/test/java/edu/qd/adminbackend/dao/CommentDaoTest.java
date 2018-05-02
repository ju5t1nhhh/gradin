package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentDaoTest {

    @Autowired
    private CommentDao commentDao;

    @Test
    public void insertOne() throws Exception {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Comment comment = new Comment(1,1,1,"justin","hello", timestamp);
        commentDao.insertOne(comment);
    }

    @Test
    public void listComment() throws Exception {
        Timestamp timestamp = Timestamp.valueOf("2018-05-02 00:00:00");
        Comment comment = new Comment(0,0,0,null,null,timestamp);
        Comment[] comments = commentDao.selectByDTO(comment,0,-1);
        for ( Comment cmt : comments )
            System.out.println(cmt);
    }

}