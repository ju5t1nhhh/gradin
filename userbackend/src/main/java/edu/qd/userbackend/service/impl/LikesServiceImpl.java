package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.LikesDao;
import edu.qd.userbackend.domain.Likes;
import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.service.LikesService;
import edu.qd.userbackend.vo.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesServiceImpl implements LikesService {

    @Autowired
    private LikesDao likesDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse modLikes(long post, int cmtId) {
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Likes likes = new Likes(post, cmtId, user.getAutoId());
        int flag = likesDao.isLikes(likes);
        int rows = 0;
        if ( flag == 0 ) {
            redisTemplate.opsForList().leftPush("likes:"+user.getId(), post+":"+cmtId);
            redisTemplate.opsForZSet().incrementScore("cmtrank:"+post,""+cmtId, 1);
            rows = likesDao.insertOne(likes);
        } else {
            redisTemplate.opsForList().remove("likes:"+user.getId(), 1, post+":"+cmtId);
            redisTemplate.opsForZSet().incrementScore("cmtrank:"+post,""+cmtId, -1);
            rows = likesDao.deleteByDTO(likes);
        }
        if ( rows > 0 ) {
            return RestResponse.successWithMsg("操作成功");
        } else {
            return RestResponse.errorWithMsg(1801, "请稍后重试");
        }
    }

    @Override
    public RestResponse myLikes(int page) {
        int offset = ( page - 1 ) * 15;
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        List<String> mylikes = redisTemplate.opsForList().range("likes:"+user.getId(), offset, offset+15);
        if ( mylikes.size() == 0 ) {
            Likes likes = new Likes();
            likes.setLiker(user.getAutoId());
            Likes[] likeses = likesDao.selectByDTO(likes, offset, 15);
            return RestResponse.successWithData("查看成功", likeses);
        }
        return RestResponse.successWithData("查看成功", mylikes);
    }
}
