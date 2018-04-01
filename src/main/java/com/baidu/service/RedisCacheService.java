package com.baidu.service;


import com.baidu.entity.Cat;
import com.baidu.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.List;

/**
 * Created by Jhon on 2018/3/31.
 */
@Service
public class RedisCacheService {
    @Autowired
    private CatRepository catRepository;


    @Autowired
    private JedisCluster jedisCluster;


    @Cacheable(value = "getCache")
    public List<Cat> getCache(){
       return catRepository.findAll();
    }

    public void setJedis(){
        jedisCluster.set("key","value");

    }
}
