package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.Complaint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.sql.Timestamp;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ComplaintDaoTest {

    @Autowired
    private ComplaintDao complaintDao;

    @Test
    public void insertOne() throws Exception {
        Complaint complaint = new Complaint(1L,1L,1,"dfgdfg",new Timestamp(new Date().getTime()));
        complaintDao.insertOne(complaint);
    }

    @Test
    public void selectByDTO() throws Exception {
        Complaint complaint = new Complaint(0,0,0,null,null);
        Complaint[] complaints = complaintDao.selectByDTO(complaint,0,-1);
        for ( Complaint com : complaints )
            System.out.println(com);

    }

}