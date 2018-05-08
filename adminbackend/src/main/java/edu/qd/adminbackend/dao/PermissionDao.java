package edu.qd.adminbackend.dao;

import edu.qd.adminbackend.domain.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao extends BaseDao<Permission> {

    Permission selectById(int id);

}
