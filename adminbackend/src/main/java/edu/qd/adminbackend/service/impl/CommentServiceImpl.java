package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.dao.CommentDao;
import edu.qd.adminbackend.domain.Comment;
import edu.qd.adminbackend.service.CommentService;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse delComment(Comment comment) {
        Comment[] comments = commentDao.selectByDTO(comment,0,-1);
        int rows = commentDao.deleteByDTO(comment);
        if ( rows > 0 ) {
            Thread thread = new Thread( () -> {
                for ( Comment cmt : comments ) {
                    redisTemplate.opsForHash().delete("comment:" + cmt.getPost() + ":" + cmt.getCmtid());
                }
            });
            thread.start();
            return RestResponse.successWithMsg("删除评论成功");
        } else {
            return RestResponse.errorWithMsg(1111, "删除评论失败");
        }
    }

    @Override
    public RestResponse listComment(Comment comment, int page) {
        int offset = ( page - 1 ) * 15;
        Comment[] comments = commentDao.selectByDTO(comment, offset, 15);
        return RestResponse.successWithData("查看指定评论成功", comments);
    }

}
