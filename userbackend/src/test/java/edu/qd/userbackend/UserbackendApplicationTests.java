package edu.qd.userbackend;

import edu.qd.userbackend.dao.PostDao;
import edu.qd.userbackend.dao.TagDao;
import edu.qd.userbackend.domain.Post;
import edu.qd.userbackend.vo.TagResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserbackendApplicationTests {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Autowired
	private PostDao postDao;

	@Autowired
	private TagDao tagDao;

	@Test
	public void contextLoads() {
		TagResponse[] responses = tagDao.selectLikeWord("h");
		for ( TagResponse tr : responses )
			System.out.println(tr);
	}

}
