package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.domain.Complaint;
import edu.qd.adminbackend.domain.ComplaintPost;
import edu.qd.adminbackend.service.ComplaintService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/list")
    @RequiresPermissions("complaint:list")
    @ApiOperation("查看举报作品与状态")
    public RestResponse listComplaintPost(ComplaintPost complaintPost, @RequestParam(defaultValue = "1") int page) {
        return complaintService.listComplaintPost(complaintPost, page);
    }

    @PostMapping("/list/post")
    @RequiresPermissions("complaint:list")
    @ApiOperation("查看举作具体内容")
    public RestResponse listComplaint(Complaint complaint, @RequestParam(defaultValue = "1") int page) {
        return complaintService.listComplaint(complaint, page);
    }

    @PostMapping("/deal")
    @RequiresPermissions("complaint:mod")
    @ApiOperation("改变举报信息状态")
    public RestResponse dealComplaint(@Valid ComplaintPost complaintPost) {
        return complaintService.dealComplaint(complaintPost);
    }

}
