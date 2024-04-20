package group.bootcamp.technicaltest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/redis")
public class RedisController {

    @Autowired
    StringRedisTemplate redisTemplate;

}
