package com.company.project.redistest;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class RedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private int count = 0;

    @GetMapping("/test")
    public void testSentinel() throws InterruptedException {
        int i = 1;
        while (true) {
            try {
                redisTemplate.opsForValue().set("wuguoqing" + i, i + "");
                System.out.println("设置key: wuguoqing" + i);
                i++;
                Thread.sleep(1000);
            } catch (Exception e) {
                log.info(e.getMessage());
            }

        }
    }

    @GetMapping("/test1")
    public String testSentinel1() throws InterruptedException {
        return "大傻逼" + count++;
    }




}
