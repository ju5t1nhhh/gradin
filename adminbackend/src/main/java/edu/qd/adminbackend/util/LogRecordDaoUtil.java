package edu.qd.adminbackend.util;

import edu.qd.adminbackend.dao.LogRecordDao;
import edu.qd.adminbackend.domain.LogRecord;
import edu.qd.adminbackend.shiro.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;

public class LogRecordDaoUtil {

    public static int insertLogRecord(LogRecordDao logRecordDao, String msg) {
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        LogRecord logRecord = new LogRecord(userInfo.getUsername(),msg,new Timestamp(new Date().getTime()));
        int rows = logRecordDao.insertOne(logRecord);
        return rows;
    }

}
