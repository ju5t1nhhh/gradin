package edu.qd.userbackend.controller;

import edu.qd.userbackend.dto.ScoreAddDTO;
import edu.qd.userbackend.service.ScoreService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/add")
    @ApiOperation("添加评分")
    public RestResponse addScore(@RequestBody ScoreAddDTO scoreAddDTO) {
        long post = scoreAddDTO.getPost();
        int score = scoreAddDTO.getScore();
        return scoreService.addScore(post, score);
    }

    @PostMapping("/del/{post}")
    @ApiOperation("删除评分")
    public RestResponse delScore(@PathVariable long post) {
        return scoreService.delScore(post);
    }

    @PostMapping("/myadd")
    @ApiOperation("个人参与的评分")
    public RestResponse listScore(@RequestParam(defaultValue = "1") int page) {
        return scoreService.listScore(page);
    }

}
