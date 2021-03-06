package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Follow;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowDao extends BaseDao<Follow> {

    int getFollowsNum(long id);

    int getFansNum(long id);

    long[] getFollows(long id);

    long[] getFans(long id);

}
