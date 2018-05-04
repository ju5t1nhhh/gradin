package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.domain.Post;
import edu.qd.userbackend.service.PostService;
import edu.qd.userbackend.vo.RestResponse;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public RestResponse addPost(Post post) {
        return null;
    }

    @Override
    public RestResponse delPost(long id) {
        return null;
    }

    @Override
    public RestResponse showPost(long id) {
        return null;
    }
}
