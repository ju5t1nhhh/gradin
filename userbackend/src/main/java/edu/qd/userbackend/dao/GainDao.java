package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Gain;
import org.springframework.stereotype.Repository;

@Repository
public interface GainDao extends BaseDao<Gain> {

    Gain[] selectByUser(long user);

    Gain[] selectByPost(long post);

}
