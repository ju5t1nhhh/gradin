package edu.qd.userbackend.service.impl;

import edu.qd.userbackend.dao.PostDao;
import edu.qd.userbackend.dao.ScoreDao;
import edu.qd.userbackend.dao.TagDao;
import edu.qd.userbackend.dao.UserDao;
import edu.qd.userbackend.domain.Post;
import edu.qd.userbackend.domain.Tag;
import edu.qd.userbackend.service.TagService;
import edu.qd.userbackend.vo.PostResponse;
import edu.qd.userbackend.vo.RestResponse;
import edu.qd.userbackend.vo.TagResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Autowired
    private PostDao postDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ScoreDao scoreDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public RestResponse search(String word) {
        TagResponse[] tagResponses = tagDao.selectLikeWord(word);
        return RestResponse.successWithData("搜索成功", tagResponses);
    }

    @Override
    public RestResponse getPosts(String word, int page) {
        int offset = ( page - 1 ) * 15;
        List<String> postInRedis = redisTemplate.opsForList().range("tag:"+word, offset, 15);
        if ( postInRedis.size() == 0 ) {
            Tag tag = new Tag();
            tag.setName(word);
            Tag[] tags = tagDao.selectByDTO(tag, offset, 15);
            for ( Tag t : tags )
                postInRedis.add("post:"+t.getPost());
        }
        List<PostResponse> posts = new LinkedList<>();
        for ( String key : postInRedis ) {
            PostResponse postResponse = getPostResInRedis(key);
            if ( StringUtils.isEmpty(postResponse.getAuthor()) ) {
                Post post = postDao.selectById(Long.parseLong(key.substring(key.indexOf(":")+1)));
                postResponse.setAuthor(userDao.selectId(post.getAuthor()));
                postResponse.setMedias(post.getMultmedia().split(","));
                postResponse.setText(post.getText());
                postResponse.setSection(post.getSection());
                postResponse.setScore(scoreDao.getScoreSum(post.getId()));
                postResponse.setScorers(scoreDao.getScorers(post.getId()));
            }
            posts.add(postResponse);
        }
        return RestResponse.successWithData("查看成功", posts);
    }

    private PostResponse getPostResInRedis(String key) {
        String author = (String) redisTemplate.opsForHash().get(key, "author");
        String[] multmedia = ((String) redisTemplate.opsForHash().get(key, "multmedia")).split(",");
        String text = (String) redisTemplate.opsForHash().get(key, "text");
        Timestamp time = Timestamp.valueOf((String) redisTemplate.opsForHash().get(key, "creatime"));
        String sectionstring = (String) redisTemplate.opsForHash().get(key, "section");
        int section = StringUtils.isEmpty(sectionstring) ? 0 : Integer.parseInt(sectionstring);
        String scorestring = (String) redisTemplate.opsForHash().get(key, "score");
        int score = StringUtils.isEmpty(scorestring) ? 0 : Integer.parseInt(scorestring);
        String scorersstring = (String) redisTemplate.opsForHash().get(key, "scorers");
        int scorers = StringUtils.isEmpty(scorersstring) ? 0 : Integer.parseInt(scorersstring);
        return new PostResponse(author, multmedia, text, section, score, scorers, time);
    }

}
