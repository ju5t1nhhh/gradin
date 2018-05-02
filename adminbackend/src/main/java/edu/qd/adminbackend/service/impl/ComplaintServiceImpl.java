package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.dao.ComplaintDao;
import edu.qd.adminbackend.dao.ComplaintPostDao;
import edu.qd.adminbackend.domain.Complaint;
import edu.qd.adminbackend.domain.ComplaintPost;
import edu.qd.adminbackend.service.ComplaintService;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintDao complaintDao;

    @Autowired
    private ComplaintPostDao complaintPostDao;

    @Override
    public RestResponse listComplaintPost(ComplaintPost complaintPost, int page) {
        int offset = ( page - 1 ) * 15;
        ComplaintPost[] complaintPosts = complaintPostDao.selectByDTO(complaintPost,offset,15);
        return RestResponse.successWithData("查看举报相关作品列表", complaintPosts);
    }

    @Override
    public RestResponse listComplaint(Complaint complaint, int page) {
        int offset = ( page - 1 ) * 15;
        Complaint[] complaints = complaintDao.selectByDTO(complaint,offset,15);
        return RestResponse.successWithData("查看举报具体信息", complaints);
    }

    @Override
    public RestResponse dealComplaint(ComplaintPost complaintPost) {
        int rows = complaintPostDao.dealComplaintStatus(complaintPost.getPost(), complaintPost.getCmtid());
        if ( rows > 0 )
            return RestResponse.successWithMsg("已处理举报状态");
        else
            return RestResponse.successWithMsg("处理举报状态失败");
    }
}
