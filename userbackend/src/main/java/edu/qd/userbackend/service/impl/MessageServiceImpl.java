package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.MessageDao;
import edu.qd.userbackend.domain.Message;
import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.service.MessageService;
import edu.qd.userbackend.vo.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse getMyMsg() {
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Message[] messages = messageDao.selectMyMessage(user.getId());
        messageDao.changeStatusRead(user.getId());
        redisTemplate.opsForHash().put("user:"+user.getId(), "msgstatus", "0");
        return RestResponse.successWithData("查看成功", messages);
    }
}
