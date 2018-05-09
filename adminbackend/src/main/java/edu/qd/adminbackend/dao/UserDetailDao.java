package edu.qd.adminbackend.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailDao extends BaseDao {

    int insert(long user);

}
