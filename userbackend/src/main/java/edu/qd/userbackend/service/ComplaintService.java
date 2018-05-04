package edu.qd.userbackend.service;

import edu.qd.userbackend.domain.Complaint;
import edu.qd.userbackend.vo.RestResponse;

public interface ComplaintService {

    RestResponse addComplaint(Complaint complaint);

}
