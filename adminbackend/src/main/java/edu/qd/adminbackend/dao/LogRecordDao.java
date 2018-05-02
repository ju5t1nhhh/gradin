package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.LogRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRecordDao extends BaseDao<LogRecord> {

}
