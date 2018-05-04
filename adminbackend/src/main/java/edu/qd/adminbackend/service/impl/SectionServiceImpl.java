package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.dao.SectionDao;
import edu.qd.adminbackend.domain.Section;
import edu.qd.adminbackend.service.SectionService;
import edu.qd.adminbackend.util.LogRecordDaoUtil;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

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
            Thread thread = new Thread( () -> {
                redisTemplate.opsForHash().put("section:"+section.getId(),"id", section.getId());
                redisTemplate.opsForHash().put("section:"+section.getId(),"name", section.getName());
                redisTemplate.opsForHash().put("section:"+section.getId(),"intro", section.getIntro());
            });
            thread.start();
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
            redisTemplate.opsForHash().delete("section:"+section.getId());
            LogRecordDaoUtil.insertLogRecord("删除版区"+section.getName());
            return RestResponse.successWithMsg("删除版区成功");
        } else
            return RestResponse.errorWithMsg(1115,"删除版区失败");
    }

    @Override
    public RestResponse modSection(Section section) {
        int rows = sectionDao.updateOne(section);
        if ( rows > 0 ) {
            Thread thread = new Thread( () -> {
                redisTemplate.opsForHash().put("section:"+section.getId(),"name", section.getName());
                redisTemplate.opsForHash().put("section:"+section.getId(),"intro", section.getIntro());
            });
            thread.start();
            LogRecordDaoUtil.insertLogRecord("修改版区"+section.getName());
            return RestResponse.successWithMsg("修改版区成功");
        } else
            return RestResponse.errorWithMsg(1116, "修改版区失败");
    }

    @Override
    public RestResponse listSection() {
        Section[] sections = sectionDao.selectByDTO(null,0,-1);
        return RestResponse.successWithData("查看版区成功", sections);
    }
}
