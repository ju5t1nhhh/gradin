package edu.qd.adminbackend.util;

import com.alibaba.fastjson.JSON;
import edu.qd.adminbackend.dao.LogRecordDao;
import edu.qd.adminbackend.domain.LogRecord;
import edu.qd.adminbackend.shiro.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.sql.Timestamp;
import java.util.Date;

public class LogRecordDaoUtil {

    @Autowired
    private static LogRecordDao logRecordDao;

    @Autowired
    private static StringRedisTemplate redisTemplate;

    public static int insertLogRecord(String msg) {
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        LogRecord logRecord = new LogRecord(userInfo.getUsername(),msg,new Timestamp(new Date().getTime()));
        int rows = logRecordDao.insertOne(logRecord);
        if ( rows > 0 )
            redisTemplate.opsForList().leftPush("logrecords", JSON.toJSONString(logRecord));
        return rows;
    }

}
