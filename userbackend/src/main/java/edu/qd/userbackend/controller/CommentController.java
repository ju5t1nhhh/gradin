package edu.qd.userbackend.controller;

import edu.qd.userbackend.domain.Comment;
import edu.qd.userbackend.service.CommentService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    @ApiOperation("添加评论")
    public RestResponse addComment(Comment comment) {
        return null;
    }

}
