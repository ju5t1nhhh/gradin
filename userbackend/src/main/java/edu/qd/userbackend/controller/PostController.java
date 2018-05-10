package edu.qd.userbackend.controller;

import edu.qd.userbackend.domain.Post;
import edu.qd.userbackend.service.PostService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/add")
    @ApiOperation("发表作品")
    public RestResponse addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @PostMapping("/del/{id}")
    @ApiOperation("删除作品")
    public RestResponse delPost(@PathVariable long id) {
        return postService.delPost(id);
    }

    @GetMapping("/{id}")
    @ApiOperation("查看作品")
    public RestResponse showPost(@PathVariable long id) {
        return postService.showPost(id);
    }

}
