package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.CommentDao;
import edu.qd.userbackend.dao.MessageDao;
import edu.qd.userbackend.domain.Comment;
import edu.qd.userbackend.domain.Message;
import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.service.CommentService;
import edu.qd.userbackend.util.GetUserInTextUtil;
import edu.qd.userbackend.vo.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    public RestResponse addComment(Comment comment) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipals().getPrimaryPrincipal();
        Timestamp timestamp = new Timestamp(new Date().getTime());
        String text = comment.getText();
        if ( text.contains("@") ) {
            Thread thread = new Thread( () -> {
                List<String> atedUsers = GetUserInTextUtil.getAtedUsers(text);
                for ( String atedUser : atedUsers ) {
                    redisTemplate.opsForValue().increment("newmsg:" + atedUser,1);
//                    redisTemplate.opsForList().leftPush("msg:" + atedUser,);
                    Message message = new Message(atedUser, user.getId(),comment.getPost(),"评论中@了你",0,timestamp);
                    messageDao.insertOne(message);
                }
            });
            thread.start();
        }
        int rows = commentDao.insertOne(comment);
        if ( rows > 0 ) {
            redisTemplate.opsForValue().set("poscmt:"+comment.getPost()+":"+comment.getCmtid(),comment.getCmtorid()+"-"+text);
            return RestResponse.successWithMsg("评论成功");
        } else
            return RestResponse.errorWithMsg(1501, "评论失败");
    }

    @Override
    public RestResponse delComment(long post, int cmtid) {

        return null;
    }

    @Override
    public RestResponse postComments(long id) {
        return null;
    }
}
