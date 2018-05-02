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
            redisTemplate.opsForList().rightPush("sw:"+sensitiveWord.getSection(), JSON.toJSONString(sensitiveWord));
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
            if ( row > 0 )
                redisTemplate.opsForList().remove("sw"+sw.getSection(), 1, JSON.toJSONString(sw));
            rows += row;
        }
        return RestResponse.successWithMsg("删除" + rows + "敏感词成功");
    }

    @Override
    public RestResponse listSensitiveWord(SensitiveWord sensitiveWord) {
        RestResponse restResponse = null;
        List<String> swStrings = redisTemplate.opsForList().range("sw:"+sensitiveWord.getSection(),0,-1);
        if ( swStrings.size() == 0 ) {
            SensitiveWord[] sensitiveWords = sensitiveWordDao.selectByDTO(sensitiveWord, 0,-1);
            Thread thread = new Thread(() -> {
                for ( SensitiveWord sw : sensitiveWords )
                    redisTemplate.opsForList().rightPush("sw:"+sw.getSection(),JSON.toJSONString(sw));
            });
            thread.start();
            restResponse = RestResponse.successWithData("查看敏感词成功", sensitiveWords);
        } else {
            List<SensitiveWord> sensitiveWordList = new LinkedList<>();
            for ( String str : swStrings )
                sensitiveWordList.add(JSON.parseObject(str,SensitiveWord.class));
            restResponse = RestResponse.successWithData("查看敏感词成功", sensitiveWordList.toArray());
        }
        return restResponse;
    }
}
