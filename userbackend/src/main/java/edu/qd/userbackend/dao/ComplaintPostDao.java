package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.ComplaintPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintPostDao extends BaseDao<ComplaintPost> {

    int addComplaintTimes(@Param("post") long post, @Param("cmtid") int cmtid);

}
