package edu.qd.userbackend.controller;

import edu.qd.userbackend.service.TagService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/search/{word}")
    @ApiOperation("搜索相关标签")
    public RestResponse search(@PathVariable String word) {
        return tagService.search(word);
    }

    @GetMapping("/post/{word}/{page}")
    @ApiOperation("获取标签文章")
    public RestResponse getPost(@PathVariable String word, @PathVariable int page) {
        return tagService.getPosts(word, page);
    }

}
