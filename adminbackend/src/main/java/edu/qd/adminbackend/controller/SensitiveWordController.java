package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.domain.SensitiveWord;
import edu.qd.adminbackend.service.SensitiveWordService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sw")
public class SensitiveWordController {

    @Autowired
    private SensitiveWordService sensitiveWordService;

    @PostMapping("/add")
    @RequiresPermissions("sw:add")
    @ApiOperation("新增敏感词")
    public RestResponse addSensitiveWord(@Valid SensitiveWord sensitiveWord) {
        return sensitiveWordService.addSensitiveWord(sensitiveWord);
    }

    @PostMapping("/del")
    @RequiresPermissions("sw:del")
    @ApiOperation("删除敏感词")
    public RestResponse delSensitiveWord(@Valid SensitiveWord sensitiveWord) {
        return sensitiveWordService.delSensitiveWord(sensitiveWord);
    }

    @PostMapping("/list")
    @RequiresPermissions("sw:list")
    @ApiOperation("查看敏感词列表")
    public RestResponse listSensitiveWord(SensitiveWord sensitiveWord) {
        return sensitiveWordService.listSensitiveWord(sensitiveWord);
    }

}
