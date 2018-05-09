package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.dao.CommentDao;
import edu.qd.adminbackend.domain.Comment;
import edu.qd.adminbackend.dto.CommentDTO;
import edu.qd.adminbackend.service.CommentService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/del")
    @RequiresPermissions("comment:del")
    @ApiOperation("删除评论")
    public RestResponse delComment(@RequestBody Comment comment) {
        return commentService.delComment(comment);
    }

    @PostMapping("/list")
    @RequiresPermissions("comment:list")
    @ApiOperation("查看评论")
    public RestResponse listComment(@RequestBody CommentDTO commentDTO) {
        Comment comment = commentDTO;
        String date = commentDTO.getDate();
        int page = commentDTO.getPage() == 0 ? 1 : commentDTO.getPage();
        return commentService.listComment(comment, date, page);
    }

}
