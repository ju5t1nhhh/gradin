package edu.qd.userbackend.controller;

import edu.qd.userbackend.domain.Comment;
import edu.qd.userbackend.dto.CommentDeleteDTO;
import edu.qd.userbackend.service.CommentService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    @ApiOperation("添加评论")
    public RestResponse addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @PostMapping("/del")
    @ApiOperation("删除评论")
    public RestResponse delComment(@RequestBody CommentDeleteDTO commentDeleteDTO) {
        long post = commentDeleteDTO.getPost();
        int cmtid = commentDeleteDTO.getCmtid();
        return commentService.delComment(post,cmtid);
    }

    @PostMapping("/post/hot/{id}")
    @ApiOperation("查看评论")
    public RestResponse postHotComments(@PathVariable long id) {
        return commentService.postHotComments(id);
    }

    @PostMapping("/post/{id}")
    @ApiOperation("查看评论")
    public RestResponse postAllComments(@PathVariable long id) {
        return commentService.postAllComments(id);
    }

}
