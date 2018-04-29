package edu.qd.adminbackend.dao;

import org.apache.ibatis.annotations.Param;

public interface BaseDao<Domain> {

    int insertOne(Domain domain);

    int updateOne(Domain domain);

    int deleteByDTO(Domain domain);

    Domain[] selectByDTO(@Param("domain") Domain domain,
                         @Param("offset") int offset,
                         @Param("length") int length);

}
