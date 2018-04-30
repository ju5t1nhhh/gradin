package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.domain.Post;
import edu.qd.adminbackend.service.PostService;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public RestResponse listPost(Post post, int page) {
        return null;
    }

    @Override
    public RestResponse delPost(long id) {
        return null;
    }
}
