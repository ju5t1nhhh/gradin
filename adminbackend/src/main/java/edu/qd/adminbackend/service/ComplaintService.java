package edu.qd.adminbackend.service;

import edu.qd.adminbackend.domain.Complaint;
import edu.qd.adminbackend.domain.ComplaintPost;
import edu.qd.adminbackend.vo.RestResponse;

public interface ComplaintService {

    RestResponse listComplaintPost(ComplaintPost complaintPost, int page);

    RestResponse listComplaint(Complaint complaint, String date, int page);

    RestResponse dealComplaint(ComplaintPost complaintPost);

}
