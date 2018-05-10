package edu.qd.userbackend.controller;

import edu.qd.userbackend.domain.Complaint;
import edu.qd.userbackend.service.ComplaintService;
import edu.qd.userbackend.vo.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/add")
    @ApiOperation("添加举报")
    public RestResponse addComplaint(@RequestBody Complaint complaint) {
        return complaintService.addComplaint(complaint);
    }

}
