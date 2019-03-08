package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.entity.Usr;
import com.example.demo.repository.UsrRepository;
import com.example.demo.service.EmailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests implements Serializable {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private UsrRepository userRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private EmailService emailService;

    @Test
    public void sendSimpleMail() throws Exception {
        emailService.sendSimpleEmail("315852911@qq.com","this is simple mail"," hello LWJ");
    }

    @Test
    public void contextLoads() {

    }

    @Before
    public void setUp() {
        //userRepository.deleteAll();
    }

    @Test
    public void testMongodb() throws Exception {


        // 创建10个User，并验证User总数
        userRepository.save(new Usr(1L, "didi", 30));
        userRepository.save(new Usr(2L, "mama", 40));
        userRepository.save(new Usr(3L, "kaka", 50));
        userRepository.save(new Usr(4L, "didi2", 30));
        userRepository.save(new Usr(5L, "mama", 40));
        userRepository.save(new Usr(6L, "kaka2", 50));
        userRepository.save(new Usr(7L, "kaka", 50));
        userRepository.save(new Usr(8L, "kao", 50));
        userRepository.save(new Usr(9L, "ekakae", 50));
        userRepository.save(new Usr(10L, "kaka5", 50));
        userRepository.save(new Usr(11L, "", 50));
        userRepository.save(new Usr(12L, null, 50));
        this.logger.info(String.valueOf(userRepository.findAll().size()));

        // 删除一个User，再验证User总数
        /*User u = userRepository.findOne(1L);
        this.logger.info(u.toString());
        userRepository.delete(u);
        this.logger.info(String.valueOf(userRepository.findAll().size()));

        // 删除一个User，再验证User总数
        u = userRepository.findByUsername("mama").get(0);
        this.logger.info(u.toString());
        userRepository.delete(u);
        this.logger.info(String.valueOf(userRepository.findAll().size()));*/

    }

    @Test
    public void testMongodb2() throws Exception {

        // 删除一个User，再验证User总数
        List<User> u1 = userRepository.findByUsernameLike("kaka");
        this.logger.info(u1.toString());
        List<User> u2 = userRepository.findByUsername("mama");
        this.logger.info(u2.toString());
        List<User> u3 = userRepository.findByAgeGreaterThan(40);
        this.logger.info(u3.toString());
        List<User> u4 = userRepository.findByAgeLessThan(40);
        this.logger.info(u4.toString());
        List<User> u5 = userRepository.findByAgeBetween(30,45);
        this.logger.info(u5.toString());
        List<User> u6 = userRepository.findByUsernameNotNull();
        this.logger.info(u6.toString());
        List<User> u7 = userRepository.findByUsernameNull();
        this.logger.info(u7.toString());
        List<User> u8 = userRepository.findByUsernameNot("kaka");
        this.logger.info(u8.toString());




    }

    @Test
    public void testMongodb3() throws Exception {

        Pageable pageable = new PageRequest(0,10);
        Page<User> u1 = userRepository.findByNameAndAgeRange("kaka",50,pageable);
        this.logger.info(u1.toString());
        Page<User> u2 = userRepository.findByNameAndAgeRange2("kaka",0,50,pageable);
        this.logger.info(u2.toString());
        Page<User> u3 = userRepository.findByNameAndAgeRange3("kaka",0,50,pageable);
        this.logger.info(u3.toString());

    }

    @Test
    public void testRedis1() throws Exception {
        // 保存字符串
        //redisTemplate.opsForValue().set("DA22222", "111");
        this.logger.info((String) redisTemplate.opsForValue().get("DA22222"));
    }

    @Test
    public void testRedis() throws Exception{
        User user = new User("用户2", 40);
        redisTemplate.opsForValue().set("用户2",user);
        // 保存对象
        User user2= (User) redisTemplate.opsForValue().get("用户2");
        this.logger.info(String.valueOf(user2.getAge()));
        this.logger.info(String.valueOf(user2.getUserName()));
    }

}
