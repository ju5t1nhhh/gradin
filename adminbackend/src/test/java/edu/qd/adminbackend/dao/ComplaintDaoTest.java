package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.Complaint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Timestamp;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ComplaintDaoTest {

    @Autowired
    private ComplaintDao complaintDao;

    @Test
    public void insertOne() throws Exception {
        Complaint complaint = new Complaint(1L,1L,1,"dfgdfg",new Timestamp(345234523));
        complaintDao.insertOne(complaint);
    }

}