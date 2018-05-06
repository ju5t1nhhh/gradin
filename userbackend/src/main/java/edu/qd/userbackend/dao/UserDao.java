package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseDao<User> {

    User selectById(String id);

    User selectByEmail(String email);

    int reduceGins(@Param("user") long user, @Param("gins") int gins);

    String selectId(long id);

}
