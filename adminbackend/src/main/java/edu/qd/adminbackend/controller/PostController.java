package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.domain.Post;
import edu.qd.adminbackend.service.PostService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/list")
    @RequiresPermissions("post:list")
    @ApiOperation("查看作品列表")
    public RestResponse listPost(Post post, @RequestParam(defaultValue = "1") int page) {
        return postService.listPost(post, page);
    }

    @PostMapping("/del/{id}")
    @RequiresPermissions("post:del")
    @ApiOperation("删除作品")
    public RestResponse delPost(@PathVariable long id) {
        return postService.delPost(id);
    }

}
