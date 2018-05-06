package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends BaseDao<Comment>{

    List<Comment> selectByTime(long post);

    int selectNewCmtId(long post);

}
