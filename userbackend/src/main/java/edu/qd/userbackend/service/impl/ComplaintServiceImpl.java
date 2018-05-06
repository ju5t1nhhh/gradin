package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.ComplaintDao;
import edu.qd.userbackend.dao.ComplaintPostDao;
import edu.qd.userbackend.domain.Complaint;
import edu.qd.userbackend.domain.ComplaintPost;
import edu.qd.userbackend.service.ComplaintService;
import edu.qd.userbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintDao complaintDao;

    @Autowired
    private ComplaintPostDao complaintPostDao;

    @Override
    public RestResponse addComplaint(Complaint complaint) {
        complaint.setCreatime(new Timestamp(new Date().getTime()));
        int rows = complaintDao.insertOne(complaint);
        if ( rows > 0 ) {
            ComplaintPost complaintPost = new ComplaintPost();
            complaintPost.setPost(complaint.getPost());
            complaintPost.setCmtid(complaint.getCmtid());
            ComplaintPost[] cps = complaintPostDao.selectByDTO(complaintPost, 0 , 1);
            if ( cps.length == 0 ) {
                complaintPost.setStatus(0);
                complaintPost.setTimes(1);
                complaintPostDao.insertOne(complaintPost);
            } else {
                complaintPostDao.addComplaintTimes(complaint.getPost(), complaint.getCmtid());
            }
            return RestResponse.successWithMsg("举报信息发送成功");
        } else {
            return RestResponse.errorWithMsg(1701, "请稍后重试");
        }
    }
}
