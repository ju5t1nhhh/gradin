package edu.qd.adminbackend.service;

import edu.qd.adminbackend.domain.Comment;
import edu.qd.adminbackend.vo.RestResponse;

public interface CommentService {

    RestResponse delComment(Comment comment);

    RestResponse listComment(Comment comment);

}
