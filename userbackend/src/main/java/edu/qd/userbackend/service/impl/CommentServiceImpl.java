package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.CommentDao;
import edu.qd.userbackend.dao.LikesDao;
import edu.qd.userbackend.dao.MessageDao;
import edu.qd.userbackend.domain.Comment;
import edu.qd.userbackend.domain.Message;
import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.service.CommentService;
import edu.qd.userbackend.util.GetUserInTextUtil;
import edu.qd.userbackend.vo.CommentResponse;
import edu.qd.userbackend.vo.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private LikesDao likesDao;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    public RestResponse addComment(Comment comment) {
        Timestamp nowtime = new Timestamp(new Date().getTime());
        comment.setCreatime(nowtime);
        comment.setCmtid(commentDao.selectNewCmtId(comment.getPost()));
        int rows = commentDao.insertOne(comment);
        if ( rows > 0 ) {
            Subject subject = SecurityUtils.getSubject();
            User user =(User) subject.getPrincipals().getPrimaryPrincipal();
            commentRedis(comment);
            String text = comment.getText();
            Message message = new Message();
            message.setFrom(comment.getPost());
            message.setSenderId(user.getId());
            message.setStatus(0);
            message.setText(user.getId()+"在评论中@了你");
            message.setCreatime(nowtime);
            List<String> usernames = GetUserInTextUtil.getAtedUsers(text,'@');
            for ( String username : usernames ) {
                message.setRcvder(username);
                //hash
                if ( messageDao.insertOne(message) > 0 ) {
                    redisTemplate.opsForHash().put("user:"+username, "msgstatus", "1");
                }
            }
            return RestResponse.successWithMsg("评论成功");
        } else {
            return RestResponse.errorWithMsg(1601, "评论失败");
        }
    }

    private void commentRedis(Comment comment) {
        //hash
        String keyHash = "comment:"+comment.getPost()+":"+comment.getCmtid();
        Map map = new HashMap();
        map.put("post" , String.valueOf(comment.getPost()));
        map.put("cmtid", String.valueOf(comment.getCmtid()));
        map.put("cmtor", String.valueOf(comment.getCmtor()));
        map.put("cmtorid", comment.getCmtorid());
        map.put("text", comment.getText());
        map.put("likes", "0");
        map.put("creatime", String.valueOf(comment.getCreatime()));
        redisTemplate.opsForHash().putAll(keyHash, map);
        //zset
        String keyZset = "cmtrank:"+comment.getPost();
        redisTemplate.opsForZSet().add(keyZset, "comment:"+comment.getPost()+":"+comment.getCmtid(), 1);
    }

    @Override
    public RestResponse delComment(long post, int cmtid) {
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setCmtid(cmtid);
        int rows = commentDao.deleteByDTO(comment);
        if ( rows > 0 ) {
            redisTemplate.opsForHash().delete("comment:"+comment.getPost()+":"+comment.getCmtid(), "post", "cmtid", "cmtor", "cmtorid", "text", "creatime", "likes");
            redisTemplate.opsForZSet().removeRange("cmtrank:"+comment.getPost(), 0, -1);
            return RestResponse.successWithMsg("删除评论成功");
        } else {
            return RestResponse.errorWithMsg(1701,"没有评论被删除");
        }
    }

    @Override
    public RestResponse postHotComments(long id) {
        Set<ZSetOperations.TypedTuple<String>> rangeWithScores = redisTemplate.opsForZSet().reverseRangeWithScores("cmtrank:"+id, 0, -1);
        Iterator<ZSetOperations.TypedTuple<String>> iterator = rangeWithScores.iterator();
        List<CommentResponse> commentList = new LinkedList<>();
        while ( iterator.hasNext() ) {
            ZSetOperations.TypedTuple next = iterator.next();
            CommentResponse comment = getCommentResponse((String) next.getValue());
            comment.setLikes(next.getScore().intValue());
            commentList.add(comment);
        }
        if ( commentList.isEmpty() ) {
            List<Comment> comments = commentDao.selectByTime(id);
            for ( Comment comment : comments )
                commentList.add(commentToResponse(comment));
            commentList.sort(Comparator.comparingInt(CommentResponse::getLikes));
        }
        return RestResponse.successWithData("查看成功", commentList);
    }

    private CommentResponse commentToResponse(Comment comment) {
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setCmtid(comment.getCmtid());
        commentResponse.setCmtor(comment.getCmtor());
        commentResponse.setCmtorid(comment.getCmtorid());
        commentResponse.setCreatime(comment.getCreatime());
        commentResponse.setPost(comment.getPost());
        commentResponse.setText(comment.getText());
        commentResponse.setLikes(likesDao.getLikes(comment.getPost(), comment.getCmtid()));
        return commentResponse;
    }

    private CommentResponse getCommentResponse(String key) {
        CommentResponse comment = new CommentResponse();
        comment.setPost(Long.valueOf((String) redisTemplate.opsForHash().get(key, "post")));
        comment.setCmtid(Integer.valueOf((String) redisTemplate.opsForHash().get(key, "cmtid")));
        comment.setCmtor(Long.valueOf((String) redisTemplate.opsForHash().get(key, "cmtor")));
        comment.setCmtorid((String) redisTemplate.opsForHash().get(key, "cmtorid"));
        comment.setText((String) redisTemplate.opsForHash().get(key, "text"));
        comment.setCreatime(Timestamp.valueOf((String) redisTemplate.opsForHash().get(key, "creatime")));
        return comment;
    }

    @Override
    public RestResponse postAllComments(long id) {
        List<Comment> comments = commentDao.selectByTime(id);
        List<CommentResponse> commentResponses = new LinkedList<>();
        for ( Comment comment : comments )
            commentResponses.add(commentToResponse(comment));
        return RestResponse.successWithData("查看成功", commentResponses);
    }
}
