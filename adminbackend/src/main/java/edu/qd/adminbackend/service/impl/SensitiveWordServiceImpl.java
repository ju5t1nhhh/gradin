package edu.qd.adminbackend.service.impl;

import com.alibaba.fastjson.JSON;
import edu.qd.adminbackend.dao.SensitiveWordDao;
import edu.qd.adminbackend.domain.SensitiveWord;
import edu.qd.adminbackend.service.SensitiveWordService;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SensitiveWordServiceImpl implements SensitiveWordService {

    @Autowired
    private SensitiveWordDao sensitiveWordDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse addSensitiveWord(SensitiveWord sensitiveWord) {
        int rows = sensitiveWordDao.insertOne(sensitiveWord);
        if ( rows > 0 ) {
            redisTemplate.opsForHash().put("sw:"+sensitiveWord.getSection()+":"+sensitiveWord.getWord(),"word",sensitiveWord.getWord());
            redisTemplate.opsForHash().put("sw:"+sensitiveWord.getSection()+":"+sensitiveWord.getWord(),"replace",sensitiveWord.getReplace());
            redisTemplate.opsForList().leftPush("senword:"+sensitiveWord.getSection(), "sw:"+sensitiveWord.getSection()+":"+sensitiveWord.getWord());
            return RestResponse.successWithMsg("新增敏感词成功");
        } else
            return RestResponse.errorWithMsg(1112, "新增敏感词失败");
    }

    @Override
    public RestResponse delSensitiveWord(SensitiveWord sensitiveWord) {
        SensitiveWord[] sensitiveWords = sensitiveWordDao.selectByDTO(sensitiveWord,0,-1);
        int rows = 0;
        for ( SensitiveWord sw : sensitiveWords ) {
            int row = sensitiveWordDao.deleteByDTO(sw);
            if ( row > 0 ) {
                redisTemplate.opsForHash().delete("sw:"+sw.getSection()+":"+sw.getWord(),"word","replace");
                redisTemplate.opsForList().remove("senword:"+sw.getSection(), "sw:"+sw.getSection()+":"+sw.getWord());
            }
            rows += row;
        }
        return RestResponse.successWithMsg("删除敏感词成功");
    }

    @Override
    public RestResponse listSensitiveWord(SensitiveWord sensitiveWord) {
        SensitiveWord[] sensitiveWords = sensitiveWordDao.selectByDTO(sensitiveWord, 0,-1);
        return RestResponse.successWithData("查看敏感词成功", sensitiveWords);
    }
}
