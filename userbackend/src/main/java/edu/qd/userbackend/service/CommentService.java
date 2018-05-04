package edu.qd.userbackend.service;

import edu.qd.userbackend.domain.Comment;
import edu.qd.userbackend.vo.RestResponse;

public interface CommentService {

    RestResponse addComment(Comment comment);

    RestResponse delComment(long post, int cmtid);

    RestResponse postComments(long id);

}
