package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.domain.Section;
import edu.qd.adminbackend.service.SectionService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/section")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @PostMapping("/add")
    @RequiresPermissions("section:add")
    @ApiOperation("新增版区")
    public RestResponse addSection(@RequestBody Section section) {
        return sectionService.addSection(section);
    }

    @PostMapping("/del/{id}")
    @RequiresPermissions("section:del")
    @ApiOperation("删除版区")
    public RestResponse delSection(@PathVariable int id) {
        return sectionService.delSection(id);
    }

    @PostMapping("/mod")
    @RequiresPermissions("section:mod")
    @ApiOperation("修改版区")
    public RestResponse modSection(@RequestBody Section section) {
        return sectionService.modSection(section);
    }

    @PostMapping("/list")
    @RequiresPermissions("section:list")
    @ApiOperation("查看版区列表")
    public RestResponse listSection() {
        return sectionService.listSection();
    }

}
