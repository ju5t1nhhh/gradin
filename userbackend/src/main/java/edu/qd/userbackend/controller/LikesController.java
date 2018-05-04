package edu.qd.userbackend.controller;

import edu.qd.userbackend.service.LikesService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/add")
    @ApiOperation("添加点赞")
    public RestResponse addLikes(long post, int cmtId) {
        return likesService.addLikes(post,cmtId);
    }

    @PostMapping("/del")
    @ApiOperation("取消点赞")
    public RestResponse disLikes(long post, int cmtId) {
        return likesService.disLikes(post,cmtId);
    }

    @PostMapping("/user")
    @ApiOperation("查看我的点赞")
    public RestResponse myLikes(int page) {
        return likesService.myLikes(page);
    }
}
