package edu.qd.adminbackend.service.impl;

import com.alibaba.fastjson.JSON;
import edu.qd.adminbackend.dao.SectionDao;
import edu.qd.adminbackend.domain.Section;
import edu.qd.adminbackend.service.SectionService;
import edu.qd.adminbackend.util.LogRecordDaoUtil;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionDao sectionDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse addSection(Section section) {
        int rows = sectionDao.insertOne(section);
        if ( rows > 0 ) {
            redisTemplate.opsForList().rightPush("section", JSON.toJSONString(section));
            LogRecordDaoUtil.insertLogRecord("新增版区"+section.getName());
            return RestResponse.successWithMsg("新增版区成功");
        } else
            return RestResponse.errorWithMsg(1114, "新增版区失败");
    }

    @Override
    public RestResponse delSection(int id) {
        Section section = new Section(id,null,null,null);
        section = sectionDao.selectByDTO(section,0,1)[0];
        int rows = sectionDao.deleteByDTO(section);
        if ( rows > 0 ) {
            redisTemplate.opsForList().remove("section", 1, JSON.toJSONString(section));
            LogRecordDaoUtil.insertLogRecord("删除版区"+section.getName());
            return RestResponse.successWithMsg("删除版区成功");
        } else
            return RestResponse.errorWithMsg(1115,"删除版区失败");
    }

    @Override
    public RestResponse modSection(Section section) {
        Section old = new Section(section.getId(),null,null,null);
        old = sectionDao.selectByDTO(old,0,1)[0];
        int rows = sectionDao.updateOne(section);
        if ( rows > 0 ) {
            redisTemplate.opsForList().remove("section",1 ,JSON.toJSONString(old));
            redisTemplate.opsForList().rightPush("section",JSON.toJSONString(section));
            LogRecordDaoUtil.insertLogRecord("修改版区"+old.getName());
            return RestResponse.successWithMsg("修改版区成功");
        } else
            return RestResponse.errorWithMsg(1116, "修改版区失败");
    }

    @Override
    public RestResponse listSection() {
        RestResponse restResponse = null;
        List<String> sectionStrings = redisTemplate.opsForList().range("section",0,-1);
        if ( sectionStrings.size() == 0 ) {
            Section[] sections = sectionDao.selectByDTO(null,0,-1);
            Thread thread = new Thread(() -> {
                for ( Section section : sections )
                    redisTemplate.opsForList().rightPush("section",JSON.toJSONString(section));
            });
            thread.start();
            restResponse = RestResponse.successWithData("查看版区成功", sections);
        } else {
            List<Section> sectionList = new LinkedList<>();
            for ( String str : sectionStrings )
                sectionList.add(JSON.parseObject(str,Section.class));
            restResponse = RestResponse.successWithData("查看版区成功", sectionList.toArray());
        }
        return restResponse;
    }
}
