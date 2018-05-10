package edu.qd.adminbackend.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionDao {

    int[] selectPermByRole(int role);

    int insertOne(@Param("role") int role, @Param("permission") int permission);

    int deleteOne(@Param("role") int role, @Param("permission") int permission);

    int getId(String name);
}