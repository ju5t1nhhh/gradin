package edu.qd.adminbackend.service.impl;

import com.alibaba.fastjson.JSON;
import edu.qd.adminbackend.dao.LogRecordDao;
import edu.qd.adminbackend.domain.LogRecord;
import edu.qd.adminbackend.service.LogRecordService;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class LogRecordServiceImpl implements LogRecordService {

    @Autowired
    private LogRecordDao logRecordDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse listLogRecord(int page) {
        int offset = ( page - 1 ) * 15;
        if ( page == 1 ) {
            List<String> logRecordStrings = redisTemplate.opsForList().range("logrecords",0,15);
            if ( logRecordStrings.size() == 0 ) {
                LogRecord[] logRecords = logRecordDao.selectByDTO(null, offset, 15);
                Thread thread = new Thread(() -> {
                   for ( LogRecord logRecord : logRecords )
                       redisTemplate.opsForList().rightPush("logrecords", JSON.toJSONString(logRecord));
                });
                thread.start();
                return RestResponse.successWithData("查看日志板成功",logRecords);
            } else {
                List<LogRecord> logRecordList = new LinkedList<>();
                for ( String str : logRecordStrings )
                    logRecordList.add(JSON.parseObject(str, LogRecord.class));
                return RestResponse.successWithData("查看日志板成功",logRecordList);
            }
        }
        LogRecord[] logRecords = logRecordDao.selectByDTO(null, offset, 15);
        return RestResponse.successWithData("查看日志板成功", logRecords);
    }

}