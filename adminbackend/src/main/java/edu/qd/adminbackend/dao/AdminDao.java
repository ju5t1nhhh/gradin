package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends BaseDao<Admin> {

    String getPassword(String loginId);

    int getRole(String loginId);

}
