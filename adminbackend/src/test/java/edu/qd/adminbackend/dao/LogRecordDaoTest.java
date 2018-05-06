package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.Complaint;
import edu.qd.adminbackend.domain.LogRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class LogRecordDaoTest {
    @Autowired
    private LogRecordDao logRecordDao;

    @Test
    public void insertOne() throws Exception {
        LogRecord logRecord = new LogRecord("gjhgj","wdwdwddwdwd", new Timestamp(54646466 ));
        logRecordDao.insertOne(logRecord);
    }
}