package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.*;
import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.domain.UserDetail;
import edu.qd.userbackend.service.UserService;
import edu.qd.userbackend.service.ValidateCodeService;
import edu.qd.userbackend.util.PasswordUtil;
import edu.qd.userbackend.vo.RestResponse;
import edu.qd.userbackend.vo.UserResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDetailDao userDetailDao;

    @Autowired
    private FollowDao followDao;

    @Autowired
    private PostDao postDao;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private ValidateCodeService validateCodeService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse register(String id, String pwd, String email) {
        pwd = PasswordUtil.encryptPassword(null,pwd);
        User user = new User(id, email, 1, pwd, 100);
        int rows = userDao.insertOne(user);
        if ( rows > 0 ) {
            addRedisUser(user);
            UserDetail userDetail = new UserDetail();
            userDetail.setUser(user.getAutoId());
            userDetailDao.insertOne(userDetail);
            return RestResponse.successWithMsg("注册成功");
        } else {
            return RestResponse.errorWithMsg(1301, "注册失败，请重试");
        }
    }

    private void addRedisUser(User user) {
        String key = "user:"+user.getId();
        redisTemplate.opsForHash().put(key, "id", user.getId());
        redisTemplate.opsForHash().put(key, "email", user.getEmail());
        redisTemplate.opsForHash().put(key, "gins", String.valueOf(user.getGins()));
        redisTemplate.opsForHash().put(key, "avatar", "");
        redisTemplate.opsForHash().put(key, "follows", "0");
        redisTemplate.opsForHash().put(key, "fans", "0");
        redisTemplate.opsForHash().put(key, "posts", "0");
        redisTemplate.opsForHash().put(key, "msgstatus", "0");
    }

    @Override
    public RestResponse modifyEmail(String newEmail, String emailCode) {
        if ( validateCodeService.checkEmailCode(emailCode) ) {
            Subject subject = SecurityUtils.getSubject();
            User user = (User) subject.getPrincipals().getPrimaryPrincipal();
            user.setEmail(newEmail);
            int rows = userDao.updateOne(user);
            if ( rows > 0 ) {
                redisTemplate.opsForHash().put("user:"+user.getId(),"email",newEmail);
                return RestResponse.successWithMsg("修改email成功");
            } else {
                return RestResponse.errorWithMsg(1306, "修改email失败");
            }
        } else {
            return RestResponse.errorWithMsg(1307, "验证码错误");
        }
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
            if ( rows > 0 ) {
                return RestResponse.successWithMsg("修改密码成功");
            } else {
                return RestResponse.errorWithMsg(1308, "修改密码失败");
            }
        } else {
            return RestResponse.errorWithMsg(1309, "原密码错误");
        }
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
    public RestResponse showPerson(String id) {
        UserResponse userResponse = getUser(id);
        if ( StringUtils.isEmpty(userResponse.getId()) ) {
            User user = userDao.selectById(id);
            if ( user == null ) {
                return RestResponse.errorWithMsg(1702, "不存在该用户");
            } else {
                UserDetail userDetail = userDetailDao.selectById(user.getAutoId());
                String uid = user.getId();
                String email = user.getEmail();
                String avatar = userDetail.getAvatar();
                int posts = postDao.getPostsNum(user.getAutoId());
                int follows = followDao.getFollowsNum(user.getAutoId());
                int fans = followDao.getFansNum(user.getAutoId());

                userResponse.setId(uid);
                userResponse.setPosts(posts);
                userResponse.setFans(fans);
                userResponse.setFollows(follows);
                userResponse.setAvatar(avatar);
                userResponse.setEmail(email);

                String key = "user:"+user.getId();
                redisTemplate.opsForHash().put(key, "id", uid);
                redisTemplate.opsForHash().put(key, "email", email);
                redisTemplate.opsForHash().put(key, "gins", ""+String.valueOf(user.getGins()));
                redisTemplate.opsForHash().put(key, "avatar", avatar);
                redisTemplate.opsForHash().put(key, "follows", ""+String.valueOf(follows));
                redisTemplate.opsForHash().put(key, "fans", ""+String.valueOf(fans));
                redisTemplate.opsForHash().put(key, "posts", ""+String.valueOf(posts));
                redisTemplate.opsForHash().put(key, "msgstatus", ""+messageDao.getNewMessageNum(uid));

                return RestResponse.successWithData("查看成功", userResponse);
            }
        } else {
            return RestResponse.successWithData("查看成功", userResponse);
        }
    }

    private UserResponse getUser(String id) {
        String key = "user:"+id;
        UserResponse userResponse = new UserResponse();
        userResponse.setId((String) redisTemplate.opsForHash().get(key, "id"));
        userResponse.setEmail((String) redisTemplate.opsForHash().get(key, "email"));
        String ginstrings = (String) redisTemplate.opsForHash().get(key, "gins");
        int gins = StringUtils.isEmpty(ginstrings) ? 0 : Integer.parseInt(ginstrings);
        userResponse.setGins(gins);
        userResponse.setAvatar((String) redisTemplate.opsForHash().get(key, "avatar"));
        String flwstrings = (String) redisTemplate.opsForHash().get(key, "follows");
        int flws = StringUtils.isEmpty(flwstrings) ? 0 : Integer.parseInt(flwstrings);
        userResponse.setFollows(flws);
        String fanstrings = (String) redisTemplate.opsForHash().get(key, "fans");
        int fans = StringUtils.isEmpty(fanstrings) ? 0 : Integer.parseInt(fanstrings);
        userResponse.setFans(fans);
        String poststrings = (String) redisTemplate.opsForHash().get(key, "posts");
        int posts = StringUtils.isEmpty(poststrings) ? 0 : Integer.parseInt(poststrings);
        userResponse.setPosts(posts);
        String msgstatusstrings = (String) redisTemplate.opsForHash().get(key, "msgstatus");
        int msgstatus = StringUtils.isEmpty(msgstatusstrings) ? 0 : Integer.parseInt(msgstatusstrings);
        userResponse.setMsgstatus(msgstatus);
        return userResponse;
    }

    @Override
    public RestResponse detailPerson() {
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        UserDetail userDetail = userDetailDao.selectById(user.getAutoId());
        if ( userDetail != null ) {
            return RestResponse.successWithData("查看成功", userDetail);
        } else {
            return RestResponse.errorWithMsg(1701, "请稍后重试");
        }
    }

    @Override
    public RestResponse checkId(String id) {
        User user = userDao.selectById(id);
        if ( user == null )
            return RestResponse.successWithMsg("ID ok");
        else
            return RestResponse.errorWithMsg(1010, "ID已被占用");
    }

    @Override
    public RestResponse checkEmail(String email) {
        User user = userDao.selectByEmail(email);
        if ( user == null )
            return RestResponse.successWithMsg("Email ok");
        else
            return RestResponse.errorWithMsg(1010, "Email已被占用");
    }

}
