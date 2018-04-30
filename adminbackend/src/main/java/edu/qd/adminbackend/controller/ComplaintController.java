package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.domain.Complaint;
import edu.qd.adminbackend.domain.ComplaintPost;
import edu.qd.adminbackend.service.ComplaintService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/list")
    @RequiresPermissions("complaint:list")
    @ApiOperation("查看举报作品与状态")
    public RestResponse listComplaintPost(ComplaintPost complaintPost) {
        return null;
    }

    @PostMapping("/list/post")
    @RequiresPermissions("complaint:list")
    @ApiOperation("查看举作具体内容")
    public RestResponse listComplaint(Complaint complaint) {
        return null;
    }



}
