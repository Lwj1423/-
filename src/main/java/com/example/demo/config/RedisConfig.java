package com.example.demo.config;

import com.example.demo.entity.User;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by lWJ on 2019-3-2.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheManager rcm = RedisCacheManager.builder(factory).build();
        return rcm;
    }

    //设置一个默认的缓存
    @Primary
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }

    @Bean
    public RedisTemplate<Object, User> userRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, User> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer<User> serializer = new Jackson2JsonRedisSerializer<User>(User.class);
        template.setDefaultSerializer(serializer);
        return template;
    }
}
