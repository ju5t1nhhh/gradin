package edu.qd.userbackend.dao;

import edu.qd.userbackend.domain.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao extends BaseDao<Message> {

    int getNewMessageNum(String id);

    Message[] selectMyMessage(String id);

    int changeStatusRead(String id);

}
