package edu.qd.adminbackend.service.impl;

import com.alibaba.fastjson.JSON;
import edu.qd.adminbackend.dao.UserDao;
import edu.qd.adminbackend.domain.User;
import edu.qd.adminbackend.service.UserService;
import edu.qd.adminbackend.util.PasswordUtil;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse addUser(User user) {
        user.setPwd(PasswordUtil.encryptPassword("salt",user.getPwd()));
        int rows = userDao.insertOne(user);
        if ( rows > 0 ) {
            user.setPwd(null);
            redisTemplate.opsForList().rightPush("users", JSON.toJSONString(user));
            return RestResponse.successWithMsg("新增用户成功");
        } else {
            return RestResponse.errorWithMsg(1100,"新增用户失败");
        }
    }

    @Override
    public RestResponse delUser(User user) {
        User[] users = userDao.selectByDTO(user,0,-1);
        int rows = userDao.deleteByDTO(user);
        if ( rows > 0 ) {
            StringBuilder sb = new StringBuilder();
            for ( User u : users ) {
                redisTemplate.opsForList().remove("users", 1, JSON.toJSONString(u));
                sb.append(u.getId());
                sb.append(' ');
            }
            return RestResponse.successWithMsg("删除用户"+sb);
        } else {
            return RestResponse.errorWithMsg(1101,"删除用户失败");
        }
    }

    @Override
    public RestResponse modifyUser(User user) {
        User condition = new User();
        condition.setAutoid(user.getAutoid());
        if ( user.getPwd() != null && !user.getPwd().equals("") )
            user.setPwd(PasswordUtil.encryptPassword("salt",user.getPwd()));
        User oldUser = userDao.selectByDTO(condition,0,1)[0];
        int rows = userDao.updateOne(user);
        if ( rows > 0 ) {
            user.setPwd(null);
            redisTemplate.opsForList().remove("users",1,JSON.toJSONString(oldUser));
            redisTemplate.opsForList().rightPush("users",JSON.toJSONString(user));
            return RestResponse.successWithMsg("修改用户" + user.getAutoid() + "成功");
        } else {
            return RestResponse.errorWithMsg(1102, "修改用户" + user.getAutoid() + "失败");
        }
    }

    @Override
    public RestResponse listUser(User user, int page) {
        RestResponse restResponse = null;
        if ( page == 1 ) {
            List<String> userStrings = redisTemplate.opsForList().range("users", offset, 15);
        }
        int offset = ( page - 1 ) * 15;

        return null;
    }
}
