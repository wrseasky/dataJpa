package com.baidu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月28日 下午4:02:35 类说明
 */
@RestController
public class RandomController {
	private Logger logger = LoggerFactory.getLogger(RandomController.class);
	@Autowired
	private CounterService counterService;
	
	@Value("${blog.value}")
	private String randomStr;
	@Value("${blog.num}")
	private int randomInt;
	@Value("${blog.bignum}")
	private long randomLong;
	@Value("${blog.within}")
	private int randomWith10;
	@Value("${blog.range}")
	private int randomRange1020;

	@RequestMapping("/random")
	public void random() {
		counterService.increment("random.count");
		System.out.println(randomStr);
		System.out.println(randomInt);
		System.out.println(randomLong);
		System.out.println(randomWith10);
		System.out.println(randomRange1020);
		
		logger.info("{} - Heartbeat status: {}", randomInt, randomLong);
	}
}
