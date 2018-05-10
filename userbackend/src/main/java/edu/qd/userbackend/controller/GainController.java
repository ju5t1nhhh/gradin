package edu.qd.userbackend.controller;

import edu.qd.userbackend.domain.Gain;
import edu.qd.userbackend.service.GainService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gain")
public class GainController {

    @Autowired
    private GainService gainService;

    @PostMapping("/add")
    @ApiOperation("打赏作品")
    public RestResponse addGain(@RequestBody Gain gain) {
        return gainService.addGain(gain);
    }

    @PostMapping("/my")
    @ApiOperation("查看我打赏的作品")
    public RestResponse myGains() {
        return gainService.myGains();
    }

    @GetMapping("/post/{post}")
    @ApiOperation("查看打赏者们")
    public RestResponse listGivers(@PathVariable long post) {
        return gainService.listGivers(post);
    }
}
