package edu.qd.userbackend.controller;

import edu.qd.userbackend.service.FollowService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/mod/{user}")
    @ApiOperation("关注或取关用户")
    public RestResponse addFollow(@PathVariable long user) {
        return followService.modFollow(user);
    }

    @GetMapping("/flw/{user}")
    @ApiOperation("查看用户关注")
    public RestResponse listFlws(@PathVariable long user) {
        return followService.listFlws(user);
    }

    @GetMapping("/flwrs/{user}")
    @ApiOperation("查看用户粉丝")
    public RestResponse listFans(@PathVariable long user) {
        return followService.listFans(user);
    }

}
