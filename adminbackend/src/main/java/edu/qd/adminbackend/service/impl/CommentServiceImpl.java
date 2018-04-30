package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.domain.Comment;
import edu.qd.adminbackend.service.CommentService;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public RestResponse delComment(Comment comment) {
        return null;
    }

    @Override
    public RestResponse listComment(Comment comment, int page) {
        return null;
    }

}
