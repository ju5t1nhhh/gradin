package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.PostDao;
import edu.qd.userbackend.dao.ScoreDao;
import edu.qd.userbackend.domain.Post;
import edu.qd.userbackend.domain.Score;
import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.service.ScoreService;
import edu.qd.userbackend.vo.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;

    @Autowired
    private PostDao postDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse addScore(long post, int score) {
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Score sc = new Score(user.getAutoId(), post, score);
        Score[] old = scoreDao.selectByDTO(sc,0,0);
        if ( old.length > 0 )
            return RestResponse.successWithMsg("你已评分");
        int rows = scoreDao.insertOne(sc);
        if ( rows > 0 ) {
            redisTemplate.opsForHash().increment("post:"+post,"score",score);
            redisTemplate.opsForHash().increment("post:"+post,"scorers",1);
            Post p = postDao.selectById(post);
            redisTemplate.opsForZSet().incrementScore("scores:"+p.getSection(), String.valueOf(post), 1);
            return RestResponse.successWithMsg("评分成功");
        } else {
            return RestResponse.errorWithMsg(1703, "请稍后重试");
        }
    }

    @Override
    public RestResponse delScore(long post) {
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Score sc = scoreDao.select(user.getAutoId(), post);
        int rows = scoreDao.deleteByDTO(sc);
        if ( rows > 0 ) {
            redisTemplate.opsForHash().increment("post:"+post,"scorers",-sc.getScore());
            Post p = postDao.selectById(post);
            redisTemplate.opsForZSet().incrementScore("scores:"+p.getSection(), String.valueOf(post), -1);
            return RestResponse.successWithMsg("取消评分成功");
        } else {
            return RestResponse.errorWithMsg(1703, "请稍后重试");
        }
    }

    @Override
    public RestResponse listScore(int page) {
        int offset = ( page - 1 ) * 15;
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Score score = new Score(user.getAutoId(),0,0);
        Score[] scores = scoreDao.selectByDTO(score, offset, 15);
        return RestResponse.successWithData("查看成功", scores);
    }
}
