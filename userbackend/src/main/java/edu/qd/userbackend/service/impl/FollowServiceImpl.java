package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.*;
import edu.qd.userbackend.domain.Follow;
import edu.qd.userbackend.domain.User;
import edu.qd.userbackend.domain.UserDetail;
import edu.qd.userbackend.service.FollowService;
import edu.qd.userbackend.vo.RestResponse;
import edu.qd.userbackend.vo.UserResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowDao followDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserDetailDao userDetailDao;

    @Autowired
    private PostDao postDao;

    @Autowired
    private MessageDao messageDao;

    @Override
    public RestResponse modFollow(long user) {
        User u = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Follow follow = new Follow(u.getAutoId(), user);
        Follow[] follows = followDao.selectByDTO(follow,0,1);
        if ( follows.length == 0 ) {
            int rows = followDao.insertOne(follow);
            if ( rows > 0 ) {
                redisTemplate.opsForSet().add("follows:"+u.getAutoId(),String.valueOf(user));
                redisTemplate.opsForSet().add("fans:"+user,String.valueOf(u.getAutoId()));
                return RestResponse.successWithMsg("关注成功");
            } else {
                return RestResponse.errorWithMsg(1702, "请稍后重试");
            }
        } else {
            int rows = followDao.deleteByDTO(follow);
            if ( rows > 0 ) {
                redisTemplate.opsForSet().remove("follows:"+u.getAutoId(),String.valueOf(user));
                redisTemplate.opsForSet().remove("fans:"+user,String.valueOf(u.getAutoId()));
                return RestResponse.successWithMsg("取关成功");
            } else {
                return RestResponse.errorWithMsg(1702, "请稍后重试");
            }
        }
    }

    @Override
    public RestResponse listFlws(long userId) {
        long[] follows = followDao.getFollows(userId);
        List<String> strings = new LinkedList<>();
        for ( long follow : follows ) {
            strings.add(userDao.selectId(follow));
        }
        List<UserResponse> userResponses = new LinkedList<>();
        for ( String id : strings ) {
            UserResponse userResponse = getUser(id);
            if ( StringUtils.isEmpty(userResponse.getId()) ) {
                User user = userDao.selectById(id);
                if ( user == null ) {
                    continue;
                } else {
                    UserDetail userDetail = userDetailDao.selectById(user.getAutoId());
                    String uid = user.getId();
                    String email = user.getEmail();
                    String avatar = userDetail.getAvatar();
                    int posts = postDao.getPostsNum(user.getAutoId());
                    int flws = followDao.getFollowsNum(user.getAutoId());
                    int fans = followDao.getFansNum(user.getAutoId());

                    userResponse.setId(uid);
                    userResponse.setPosts(posts);
                    userResponse.setFans(fans);
                    userResponse.setFollows(flws);
                    userResponse.setAvatar(avatar);
                    userResponse.setEmail(email);

                    String key = "user:"+user.getId();
                    redisTemplate.opsForHash().put(key, "id", uid);
                    redisTemplate.opsForHash().put(key, "email", email);
                    redisTemplate.opsForHash().put(key, "gins", ""+String.valueOf(user.getGins()));
                    redisTemplate.opsForHash().put(key, "avatar", avatar);
                    redisTemplate.opsForHash().put(key, "follows", ""+String.valueOf(flws));
                    redisTemplate.opsForHash().put(key, "fans", ""+String.valueOf(fans));
                    redisTemplate.opsForHash().put(key, "posts", ""+String.valueOf(posts));
                    redisTemplate.opsForHash().put(key, "msgstatus", ""+messageDao.getNewMessageNum(uid));
                }
            }
            userResponses.add(getUser(id));
        }
        return RestResponse.successWithData("查看成功", userResponses);
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
    public RestResponse listFans(long userId) {
        long[] follows = followDao.getFans(userId);
        List<String> strings = new LinkedList<>();
        for ( long follow : follows ) {
            strings.add(userDao.selectId(follow));
        }
        List<UserResponse> userResponses = new LinkedList<>();
        for ( String id : strings ) {
            UserResponse userResponse = getUser(id);
            if ( StringUtils.isEmpty(userResponse.getId()) ) {
                User user = userDao.selectById(id);
                if ( user == null ) {
                    continue;
                } else {
                    UserDetail userDetail = userDetailDao.selectById(user.getAutoId());
                    String uid = user.getId();
                    String email = user.getEmail();
                    String avatar = userDetail.getAvatar();
                    int posts = postDao.getPostsNum(user.getAutoId());
                    int flws = followDao.getFollowsNum(user.getAutoId());
                    int fans = followDao.getFansNum(user.getAutoId());

                    userResponse.setId(uid);
                    userResponse.setPosts(posts);
                    userResponse.setFans(fans);
                    userResponse.setFollows(flws);
                    userResponse.setAvatar(avatar);
                    userResponse.setEmail(email);

                    String key = "user:"+user.getId();
                    redisTemplate.opsForHash().put(key, "id", uid);
                    redisTemplate.opsForHash().put(key, "email", email);
                    redisTemplate.opsForHash().put(key, "gins", ""+String.valueOf(user.getGins()));
                    redisTemplate.opsForHash().put(key, "avatar", avatar);
                    redisTemplate.opsForHash().put(key, "follows", ""+String.valueOf(flws));
                    redisTemplate.opsForHash().put(key, "fans", ""+String.valueOf(fans));
                    redisTemplate.opsForHash().put(key, "posts", ""+String.valueOf(posts));
                    redisTemplate.opsForHash().put(key, "msgstatus", ""+String.valueOf(messageDao.getNewMessageNum(uid)));
                }
            }
            userResponses.add(getUser(id));
        }
        return RestResponse.successWithData("查看成功", userResponses);
    }
}
