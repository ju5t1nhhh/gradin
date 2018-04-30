package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.domain.Comment;
import edu.qd.adminbackend.service.CommentService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/del")
    @RequiresPermissions("comment:del")
    @ApiOperation("删除评论")
    public RestResponse delComment(@Valid Comment comment) {
        return commentService.delComment(comment);
    }

    @PostMapping("/list")
    @RequiresPermissions("comment:list")
    @ApiOperation("查看评论")
    public RestResponse listComment(Comment comment,@RequestParam(defaultValue = "1") int page) {
        return commentService.listComment(comment, page);
    }

}
