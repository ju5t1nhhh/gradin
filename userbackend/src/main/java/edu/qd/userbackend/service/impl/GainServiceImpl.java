package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.GainDao;
import edu.qd.userbackend.dao.UserDao;
import edu.qd.userbackend.domain.Gain;
import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.service.GainService;
import edu.qd.userbackend.vo.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class GainServiceImpl implements GainService {

    @Autowired
    private GainDao gainDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse addGain(Gain gain) {
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        gain.setGiver(user.getAutoId());
        User u = userDao.selectById(user.getId());
        if ( u.getGins() < gain.getGins() )
            return RestResponse.successWithMsg("gins不足");
        int rows = gainDao.insertOne(gain);
        if ( rows > 0 ) {
            userDao.reduceGins(user.getAutoId(), gain.getGins());
            redisTemplate.opsForHash().increment("user:"+user.getId(), "gins", -gain.getGins());
            return RestResponse.successWithMsg("打赏成功");
        } else {
            return RestResponse.errorWithMsg(1702, "请稍后重试");
        }
    }

    @Override
    public RestResponse myGains() {
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Gain[] gains = gainDao.selectByUser(user.getAutoId());
        return RestResponse.successWithData("查看成功", gains);
    }

    @Override
    public RestResponse listGivers(long post) {
        Gain[] gains = gainDao.selectByPost(post);
        return RestResponse.successWithData("查看成功", gains);
    }
}
