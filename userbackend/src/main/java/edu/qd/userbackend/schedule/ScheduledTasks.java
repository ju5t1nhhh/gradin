package edu.qd.userbackend.schedule;

import edu.qd.userbackend.dao.SectionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@Component
public class ScheduledTasks {

    private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SectionDao sectionDao;

    //每15分钟更新一次
    @Scheduled(initialDelay = 1000, fixedRate = 15*60*1000)
    public void hotpost() {
        logger.info("更新hotpost " + new Date().toString());
        int[] sections = sectionDao.getAllSectionId();
        for ( int sectionId : sections ) {
            Set<ZSetOperations.TypedTuple<String>> hotposts = redisTemplate.opsForZSet().rangeWithScores("hotpost:"+sectionId, 0, -1);
            Iterator<ZSetOperations.TypedTuple<String>> iterator  = hotposts.iterator();
            while( iterator.hasNext() ) {
                ZSetOperations.TypedTuple<String> typedTuple = iterator.next();
                String postId = typedTuple.getValue();
                double oldScore = typedTuple.getScore(); //旧作品分数
                Double scorersD = redisTemplate.opsForZSet().score("scores:"+sectionId, postId);
                double scorers = scorersD == null ? 0 : scorersD;
                long cmts = redisTemplate.opsForZSet().size("cmtrank:"+postId);
                String creatime = (String) redisTemplate.opsForHash().get("post:"+postId, "creatime");
                long time = creatime == null ? 0 : Timestamp.valueOf(creatime).getTime();
                double newScore = scorers +  ( cmts << 1 ) + ( time >> 7 );
                redisTemplate.opsForZSet().incrementScore("hotpost:"+sectionId, postId, newScore - oldScore);
            }
            redisTemplate.opsForZSet().removeRange("hotpost:"+sectionId, 100, -1);
        }
    }

}
