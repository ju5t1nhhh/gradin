package edu.qd.adminbackend.redis;

import com.alibaba.fastjson.JSON;
import edu.qd.adminbackend.domain.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testLink() throws Exception {
        List<String> strings = new LinkedList<>();
        strings.add("hahaha");
        strings.add("wdwdwd");
        strings.add("gtgtgt");
        String[] strings1 = new String[]{"wdwdwd","asdasd","wdwdw"};
        System.out.println(JSON.toJSONString(strings));
        System.out.println(JSON.toJSONString(strings1));
    }

}
