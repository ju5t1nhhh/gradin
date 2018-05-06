package edu.qd.userbackend.controller;

import edu.qd.userbackend.service.LikesService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/mod")
    @ApiOperation("取赞或点赞")
    public RestResponse modLikes(long post, int cmtId) {
        return likesService.modLikes(post,cmtId);
    }

    @PostMapping("/user")
    @ApiOperation("查看我的点赞")
    public RestResponse myLikes(@RequestParam(defaultValue = "1") int page) {
        return likesService.myLikes(page);
    }
}
