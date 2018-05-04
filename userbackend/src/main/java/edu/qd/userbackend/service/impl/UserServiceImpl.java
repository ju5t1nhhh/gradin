package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.UserDao;
import edu.qd.userbackend.dao.UserDetailDao;
import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.domain.UserDetail;
import edu.qd.userbackend.service.UserService;
import edu.qd.userbackend.service.ValidateCodeService;
import edu.qd.userbackend.util.PasswordUtil;
import edu.qd.userbackend.vo.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
    private ValidateCodeService validateCodeService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse register(String id, String pwd, String email, String ecode) {
        if ( validateCodeService.checkEmailCode(ecode) ) {
            pwd = PasswordUtil.encryptPassword(null,pwd);
            User user = new User(id, email, 1, pwd, 100);
            int rows = userDao.insertOne(user);
            if ( rows > 0 )
                return RestResponse.successWithMsg("注册成功");
            else
                return RestResponse.errorWithMsg(1301, "注册失败");
        } else
            return RestResponse.errorWithMsg(1302, "验证码错误");
    }

    @Override
    public RestResponse modifyId(String id) {
        User user = userDao.selectById(id);
        if ( user != null )
            return RestResponse.errorWithMsg(1303, "已存在该id");
        Subject subject = SecurityUtils.getSubject();
        User u = (User) subject.getPrincipals().getPrimaryPrincipal();
        if ( u.getGins() < 10 )
            return RestResponse.errorWithMsg(1304,"Gins不足");
        u.setId(id);
        u.setGins(u.getGins()-10);
        int rows = userDao.updateOne(u);
        if ( rows > 0 )
            return RestResponse.successWithMsg("修改id成功");
        else
            return RestResponse.errorWithMsg(1305,"修改失败");
    }

    @Override
    public RestResponse modifyEmail(String newEmail, String emailCode) {
        if ( validateCodeService.checkEmailCode(emailCode) ) {
            Subject subject = SecurityUtils.getSubject();
            User user = (User) subject.getPrincipals().getPrimaryPrincipal();
            user.setEmail(newEmail);
            int rows = userDao.updateOne(user);
            if ( rows > 0 )
                return RestResponse.successWithMsg("修改email成功");
            else
                return RestResponse.errorWithMsg(1306, "修改email失败");
        } else
            return RestResponse.errorWithMsg(1307, "验证码错误");
    }

    @Override
    public RestResponse modifyPwd(String oldPassword, String newPassword) {
        oldPassword = PasswordUtil.encryptPassword(null,oldPassword);
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipals().getPrimaryPrincipal();
        if ( user.getPwd().equals(oldPassword) ) {
            newPassword = PasswordUtil.encryptPassword(null,newPassword);
            user.setPwd(newPassword);
            int rows = userDao.updateOne(user);
            if ( rows > 0 )
                return RestResponse.successWithMsg("修改密码成功");
            else
                return RestResponse.errorWithMsg(1308,"修改密码失败");
        } else
            return RestResponse.errorWithMsg(1309,"原密码错误");
    }

    @Override
    public RestResponse modifyDetail(UserDetail userDetail) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipals().getPrimaryPrincipal();
        userDetail.setUser(user.getAutoId());
        int rows = userDetailDao.updateOne(userDetail);
        if ( rows > 0 )
            return RestResponse.successWithMsg("修改成功");
        else
            return RestResponse.errorWithMsg(1310, "修改失败");
    }

    @Override
    public RestResponse showPerson(long id) {
        return null;
    }
}
