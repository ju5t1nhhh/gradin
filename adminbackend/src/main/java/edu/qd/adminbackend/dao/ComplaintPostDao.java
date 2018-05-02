package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.ComplaintPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface ComplaintPostDao extends BaseDao<ComplaintPost> {

    int dealComplaintStatus(@Param("post") long post, @Param("cmtid") int cmtid);

}
