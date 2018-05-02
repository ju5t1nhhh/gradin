package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.dao.PostDao;
import edu.qd.adminbackend.domain.Post;
import edu.qd.adminbackend.service.PostService;
import edu.qd.adminbackend.util.LogRecordDaoUtil;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public RestResponse listPost(Post post, int page) {
        int offset = ( page - 1 ) * 15;
        Post[] posts = postDao.selectByDTO(post, offset, 15);
        return RestResponse.successWithData("查看作品列表成功", posts);
    }

    @Override
    public RestResponse delPost(long id) {
        Post post = new Post();
        post.setId(id);
        int rows = postDao.deleteByDTO(post);
        if ( rows > 0 ) {
            LogRecordDaoUtil.insertLogRecord("删除作品:"+post.getId());
            return RestResponse.successWithMsg("删除作品成功");
        } else
            return RestResponse.errorWithMsg(1119,"删除作品失败");
    }
}