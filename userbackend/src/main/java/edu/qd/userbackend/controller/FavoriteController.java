package edu.qd.userbackend.controller;

import edu.qd.userbackend.service.FavoriteService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/add/{post}")
    @ApiOperation("添加收藏")
    public RestResponse addFavor(@PathVariable long post) {
        return favoriteService.addFavor(post);
    }

    @PostMapping("/cancel/{post}")
    @ApiOperation("取消收藏")
    public RestResponse cancelFavor(@PathVariable long post) {
        return favoriteService.cancelFavor(post);
    }

    @PostMapping("/list")
    @ApiOperation("查看收藏")
    public RestResponse listFavor() {
        return favoriteService.listFavor();
    }
}
