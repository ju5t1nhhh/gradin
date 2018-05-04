package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Complaint;
import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.util.PasswordUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class ComplaintDaoTest {
    @Autowired
    private ComplaintDao complaintDao;

    @Test
    public void selectById() throws Exception {
        Complaint complaint = new Complaint(1L,1L,112,"dasdasda",new Timestamp(1213123313));
        complaintDao.insertOne(complaint);
    }

    @Test
    public void selectByEmail() throws Exception {
    }

}