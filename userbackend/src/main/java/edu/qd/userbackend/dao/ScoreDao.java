package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Score;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreDao extends BaseDao<Score> {

    int getScoreSum(long post);

    int getScorers(long post);

    Score select(@Param("user") long user, @Param("post") long post);

}
