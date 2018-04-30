package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.service.LogRecordService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logrecord")
public class LogRecordController {

    @Autowired
    private LogRecordService logRecordService;

    @PostMapping("/list")
    @RequiresPermissions("logrecord:list")
    @ApiOperation("查看日志板")
    public RestResponse listLogRecord(@RequestParam(defaultValue = "1") int page) {
        return logRecordService.listLogRecord(page);
    }

}
