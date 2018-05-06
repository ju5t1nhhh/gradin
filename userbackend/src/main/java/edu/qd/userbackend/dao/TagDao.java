package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Tag;
import edu.qd.userbackend.vo.TagResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDao extends BaseDao<Tag> {

    TagResponse[] selectLikeWord(String word);

}
