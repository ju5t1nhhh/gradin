package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.dao.LogRecordDao;
import edu.qd.adminbackend.domain.LogRecord;
import edu.qd.adminbackend.service.LogRecordService;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogRecordServiceImpl implements LogRecordService {

    @Autowired
    private LogRecordDao logRecordDao;

    @Override
    public RestResponse listLogRecord(int page) {
        int offset = ( page - 1 ) * 15;
        LogRecord[] logRecords = logRecordDao.selectByDTO(null, offset, 15);
        return RestResponse.successWithData("查看日志板成功", logRecords);
    }

}