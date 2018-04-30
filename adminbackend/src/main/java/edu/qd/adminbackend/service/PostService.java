package edu.qd.adminbackend.service;

import edu.qd.adminbackend.domain.Post;
import edu.qd.adminbackend.vo.RestResponse;

public interface PostService {

    RestResponse listPost(Post post, int page);

    RestResponse delPost(long id);

}
