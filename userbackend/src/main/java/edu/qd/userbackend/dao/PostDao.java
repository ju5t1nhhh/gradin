package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends BaseDao<Post> {

    int getPostsNum(long id);

    Post selectById(long id);

    int deleteById(long id);

}
