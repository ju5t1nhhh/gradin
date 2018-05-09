package edu.qd.adminbackend.controller;

import edu.qd.adminbackend.domain.Complaint;
import edu.qd.adminbackend.domain.ComplaintPost;
import edu.qd.adminbackend.dto.ComplaintDTO;
import edu.qd.adminbackend.dto.ComplaintPostDTO;
import edu.qd.adminbackend.service.ComplaintService;
import edu.qd.adminbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/list")
    @RequiresPermissions("complaint:list")
    @ApiOperation("查看举报作品与状态")
    public RestResponse listComplaintPost(@RequestBody ComplaintPostDTO complaintPostDTO) {
        ComplaintPost complaintPost = complaintPostDTO;
        int page = complaintPostDTO.getPage() == 0 ? 1 : complaintPostDTO.getPage();
        return complaintService.listComplaintPost(complaintPost, page);
    }

    @PostMapping("/list/post")
    @RequiresPermissions("complaint:list")
    @ApiOperation("查看举报具体内容")
    public RestResponse listComplaint(@RequestBody ComplaintDTO complaintDTO) {
        System.out.println(complaintDTO);
        Complaint complaint = complaintDTO;
        String date = complaintDTO.getDate();
        int page = complaintDTO.getPage() == 0 ? 1 : complaintDTO.getPage();
        return complaintService.listComplaint(complaint, date, page);
    }

    @PostMapping("/deal")
    @RequiresPermissions("complaint:mod")
    @ApiOperation("改变举报信息状态")
    public RestResponse dealComplaint(@RequestBody ComplaintPost complaintPost) {
        return complaintService.dealComplaint(complaintPost);
    }

}
