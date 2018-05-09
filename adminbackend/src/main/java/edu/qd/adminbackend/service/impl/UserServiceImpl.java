package edu.qd.adminbackend.service.impl;

import edu.qd.adminbackend.dao.LogRecordDao;
import edu.qd.adminbackend.dao.UserDao;
import edu.qd.adminbackend.dao.UserDetailDao;
import edu.qd.adminbackend.domain.User;
import edu.qd.adminbackend.dto.UserDTO;
import edu.qd.adminbackend.service.UserService;
import edu.qd.adminbackend.util.LogRecordDaoUtil;
import edu.qd.adminbackend.util.PasswordUtil;
import edu.qd.adminbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDetailDao userDetailDao;

    @Autowired
    private LogRecordDao logRecordDao;

    @Override
    public RestResponse addUser(User user) {
        user.setPwd(PasswordUtil.encryptPassword("salt",user.getPwd()));
        int rows = userDao.insertOne(user);
        if ( rows > 0 ) {
            userDetailDao.insert(user.getAutoid());
            LogRecordDaoUtil.insertLogRecord(logRecordDao,"新增用户:"+user.getAutoid()+":"+user.getId());
            return RestResponse.successWithMsg("新增用户成功");
        } else
            return RestResponse.errorWithMsg(1100,"新增用户失败");
    }

    @Override
    public RestResponse delUser(User user) {
        int rows = userDao.deleteById(user.getId());
        if ( rows > 0 ) {
            LogRecordDaoUtil.insertLogRecord(logRecordDao, "删除用户:"+user.getId());
            return RestResponse.successWithMsg("删除用户"+user.getId());
        } else {
            return RestResponse.errorWithMsg(1101,"删除用户失败");
        }
    }

    @Override
    public RestResponse modifyUser(User user) {
        if ( user.getPwd() != null && !user.getPwd().trim().equals("") )
            user.setPwd(PasswordUtil.encryptPassword("salt",user.getPwd()));
        int rows = userDao.updateOne(user);
        if ( rows > 0 ) {
            LogRecordDaoUtil.insertLogRecord(logRecordDao, "修改用户:"+user.getAutoid()+":"+user.getId());
            return RestResponse.successWithMsg("修改用户" + user.getAutoid() + "成功");
        } else
            return RestResponse.errorWithMsg(1102, "修改用户" + user.getAutoid() + "失败");
    }

    @Override
    public RestResponse listUser(User user, int page) {
        int offset = ( page - 1 ) * 15;
        User[] users = userDao.selectByDTO(user, offset, 15);
        if ( users.length == 0 )
            return RestResponse.successWithMsg("找不到符合条件用户");
        else
            return RestResponse.successWithData("查看成功",users);
    }

    @Override
    public RestResponse getUser(UserDTO userDTO) {
        User user = userDTO;
        User[] users = userDao.selectByDTO(user,0,1);
        if ( users.length == 0 ) {
            return RestResponse.errorWithMsg(1901, "用户不存在");
        } else {
            return RestResponse.successWithData("查看成功", users[0]);
        }
    }
}
