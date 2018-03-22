package com.baidu.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redis/")
@SuppressWarnings("all")
public class RedisController {
	 
	RedisTemplate jedisTemplate;
	
	@RequestMapping("aa")
    public void testPublishMessage() throws Exception {
//		Banner a = new Banner();
//		a.setId(1l);
//		a.setUrl("url");
//		a.setTitle("title");
//		String json = new Gson().toJson(a);
//		jedisTemplate.convertAndSend("hellooooo", json);
//		jedisTemplate.convertAndSend("springtv", json);
//		jedisTemplate.convertAndSend("tvvvvvvvvv", json);
		
		
		//String  [set name "runoob"]  [get name] / [set age "runoob"] [get age]
		BoundValueOperations boundValueOps = jedisTemplate.boundValueOps("");
		//获取值
		boundValueOps.get();
		//设置值
		boundValueOps.set("");
		//设置过期时间
		boundValueOps.expire(7100, TimeUnit.SECONDS);
		
		
		//hash key---[key:value,key:value,key:value]	[HMSET ukey username "yiibai" password "passswd123" points 200]
		BoundHashOperations boundHashOps = jedisTemplate.boundHashOps("video_top_date");
		//增 改
		boundHashOps.put("movieDayReleaseDate", "");
		//删
		boundHashOps.delete("key1","key2");
		//删除过期的数据
		boundHashOps.persist();
		//查
		boundHashOps.get("releaseDate");
		//获取所有的键值对
		Map<String, String> maps = boundHashOps.entries();
		//设置生存过期时间 
		boundHashOps.expireAt(new Date());
		boundHashOps.expire(7100, TimeUnit.SECONDS);
		
		
		
		//list key---[values]
		BoundListOperations boundListOps = jedisTemplate.boundListOps("");
		//增
		boundListOps.leftPush("");//左侧入栈，先进后出，和右侧相比，左侧先出 
		boundListOps.rightPush("");//右侧入栈 先进先出 ，和左侧相比，左侧先出 
		//删
		boundListOps.remove(0, "");
		//改
		//查
		boundListOps.leftPop();
		boundListOps.rightPop();
		List<String> values = boundListOps.range(0, -1);
		//把第一个数据替换成cs04
		boundListOps.set(0, "cs04");
		//从第一个数据到第4个数据删除
	    boundListOps.trim(0, 3);
	    boundListOps.expire(7100, TimeUnit.SECONDS);
	
		
		//set key---[values] sadd key member [sadd runoob redis , sadd runoob mongodb]
		BoundSetOperations boundSetOps = jedisTemplate.boundSetOps("");
		boundSetOps.add("value1","value2");
		boundSetOps.remove("value1","value2");
		//pop出一个数据,第一个数据被pop出
		boundSetOps.pop();
		//获取set里的所有数据,每次显示的顺序可能不一样
		boundSetOps.members();
		boundSetOps.expire(7100, TimeUnit.SECONDS);
		
		
		//ZSet key---[score:member,score:member,score:member]  zadd key score member [zadd runoob 0 redis , zadd runoob 0 mongodb]
		BoundZSetOperations boundZSetOps = jedisTemplate.boundZSetOps("");
		boundZSetOps.add("member", 1);
		boundZSetOps.remove("member1","member2");
		boundZSetOps.incrementScore("member1", 1);
		boundZSetOps.range(1l, 2l);// range(0, -1); //返回指定区间的元素 
		boundZSetOps.rangeByScore(1d, 2d);
		boundZSetOps.expire(7100, TimeUnit.SECONDS);
		
    }  
}
