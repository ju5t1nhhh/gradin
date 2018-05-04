package edu.qd.userbackend.controller;

import edu.qd.userbackend.service.ScoreService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/add")
    @ApiOperation("添加评分")
    public RestResponse addScore(long post, int score) {
        return scoreService.addScore(post, score);
    }

    @PostMapping("/del")
    @ApiOperation("删除评分")
    public RestResponse delScore(long post) {
        return scoreService.delScore(post);
    }

    @PostMapping("/myadd")
    @ApiOperation("个人参与的评分")
    public RestResponse listScore(int page) {
        return scoreService.listScore(page);
    }

}
