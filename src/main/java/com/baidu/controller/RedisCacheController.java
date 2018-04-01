package com.baidu.controller;

import com.baidu.entity.Cat;
import com.baidu.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jhon on 2018/3/31.
 */
@RestController
public class RedisCacheController {

    @Autowired
    private RedisCacheService redisCacheService;
    @RequestMapping("/cache")
    public List<Cat> getRedisCache(){
        return redisCacheService.getCache();
    }

}
