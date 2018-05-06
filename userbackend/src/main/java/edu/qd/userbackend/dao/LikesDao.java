package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Likes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesDao extends BaseDao<Likes> {

    int getLikes(@Param("post") long post, @Param("cmtid") int cmtid);

    int isLikes(Likes likes);

}
