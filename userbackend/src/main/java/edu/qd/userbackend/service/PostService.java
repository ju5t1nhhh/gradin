package edu.qd.userbackend.service;

import edu.qd.userbackend.domain.Post;
import edu.qd.userbackend.vo.RestResponse;

public interface PostService {

    RestResponse addPost(Post post);

    RestResponse delPost(long id);

    RestResponse showPost(long id);

}
