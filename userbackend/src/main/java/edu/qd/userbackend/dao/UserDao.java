package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseDao<User> {

    User selectById(String id);

    User selectByEmail(String email);

}
