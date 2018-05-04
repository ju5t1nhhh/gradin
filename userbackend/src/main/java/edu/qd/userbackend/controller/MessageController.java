package edu.qd.userbackend.controller;

import edu.qd.userbackend.service.MessageService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/my")
    @ApiOperation("查看我的消息")
    public RestResponse getMyMsg() {
        return messageService.getMyMsg();
    }
}
