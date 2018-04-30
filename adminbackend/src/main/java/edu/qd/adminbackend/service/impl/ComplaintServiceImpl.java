package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.domain.Complaint;
import edu.qd.adminbackend.domain.ComplaintPost;
import edu.qd.adminbackend.service.ComplaintService;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.stereotype.Service;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Override
    public RestResponse listComplaintPost(ComplaintPost complaintPost, int page) {
        return null;
    }

    @Override
    public RestResponse listComplaint(Complaint complaint, int page) {
        return null;
    }

    @Override
    public RestResponse dealComplaint(ComplaintPost complaintPost) {
        return null;
    }
}
