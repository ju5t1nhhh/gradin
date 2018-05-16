package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.*;
import edu.qd.userbackend.domain.*;
import edu.qd.userbackend.service.PostService;
import edu.qd.userbackend.util.GetUserInTextUtil;
import edu.qd.userbackend.vo.PostResponse;
import edu.qd.userbackend.vo.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private ScoreDao scoreDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse addPost(Post post) {
        User u = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        Timestamp nowtime = new Timestamp(new Date().getTime());
        post.setCreatime(nowtime);
        post.setAuthor(u.getAutoId());

        List<String> strings = redisTemplate.opsForList().range("senword:"+post.getSection(),0, -1);
        List<SensitiveWord> sensitiveWords = new LinkedList<>();
        for ( String str : strings ) {
            SensitiveWord sw = new SensitiveWord();
            sw.setWord((String) redisTemplate.opsForHash().get(str, "word"));
            sw.setReplace((String) redisTemplate.opsForHash().get(str, "replace"));
            sensitiveWords.add(sw);
        }
        String media = "";
        for ( String med : post.getMedias() ) {
            media = media + med + ",";
        }
        post.setMultmedia(media);

        String newText = post.getText();
        for ( SensitiveWord sensitiveWord : sensitiveWords )
            newText = newText.replaceAll(sensitiveWord.getWord(),sensitiveWord.getReplace());
        post.setText(newText);

        int rows = postDao.insertOne(post);
        if ( rows > 0 ) {

            List<String> tags = GetUserInTextUtil.getAtedUsers(post.getText(), '#');
            for ( String tag : tags ) {
                Tag t = new Tag(tag, post.getId());
                tagDao.insertOne(t);
                redisTemplate.opsForList().leftPush("tag:"+tag, "post:"+post.getId());
            }

            List<String> users = GetUserInTextUtil.getAtedUsers(post.getText(),'@');
            for ( String user : users ) {
                String fromid = userDao.selectId(post.getAuthor());
                Message message = new Message(user,fromid,post.getId(),fromid+"在作品中@了你",0,nowtime);
                if ( messageDao.insertOne(message) > 0 ) {
                    redisTemplate.opsForHash().put("user:"+user, "msgstatus", "1");
                }
            }

            String hashKey = "post:"+post.getId();
            redisTemplate.opsForHash().put(hashKey, "author", ""+post.getAuthor());
            redisTemplate.opsForHash().put(hashKey, "multmedia", ""+post.getMultmedia());
            redisTemplate.opsForHash().put(hashKey, "text", ""+post.getText());
            redisTemplate.opsForHash().put(hashKey, "creatime", ""+post.getCreatime());
            redisTemplate.opsForHash().put(hashKey, "section", ""+post.getSection());
            redisTemplate.opsForHash().put(hashKey, "score", "0");
            redisTemplate.opsForHash().put(hashKey, "scorers", "0");

            redisTemplate.opsForHash().increment("user:"+userDao.selectId(post.getAuthor()), "posts" , 1);

            redisTemplate.opsForZSet().incrementScore("hotpost:"+post.getSection(), ""+post.getId(), 0);

            return RestResponse.successWithMsg("发表成功");
        } else {
            return RestResponse.errorWithMsg(1801, "请稍后重试");
        }
    }

    @Override
    public RestResponse delPost(long id) {
        Post post = postDao.selectById(id);
        int rows = postDao.deleteById(id);
        if ( rows > 0 ) {
            String hashKey = "post:"+id;
            redisTemplate.opsForHash().delete(hashKey,"author","multmedia","text","creatime","section","score","scorers");
            redisTemplate.opsForHash().increment("user:"+userDao.selectId(post.getAuthor()), "posts" , -1);
            return RestResponse.successWithMsg("删除成功");
        } else {
            return RestResponse.errorWithMsg(1901, "请稍后重试");
        }
    }

    @Override
    public RestResponse showPost(long id) {
        Post post = postDao.selectById(id);
        PostResponse postResponse = new PostResponse();

        postResponse.setSection(post.getSection());
        postResponse.setText(post.getText());
        postResponse.setAuthor(userDao.selectId(post.getAuthor()));
        postResponse.setCreatime(post.getCreatime());
        postResponse.setScorers(scoreDao.getScorers(id));
        postResponse.setScore(scoreDao.getScoreSum(id));
        postResponse.setMedias(post.getMultmedia().split(","));

        return RestResponse.successWithData("查看成功", postResponse);
    }
}
