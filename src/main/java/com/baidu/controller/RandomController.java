package com.baidu.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.text.RandomStringGenerator;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月28日 下午4:02:35 类说明
 */
@RestController
public class RandomController {

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
	public String random() {
		/**
		 * 统计被调用次数
		 */
		counterService.increment("random.count");
		
		System.out.println(randomStr);
		System.out.println(randomInt);
		System.out.println(randomLong);
		System.out.println(randomWith10);
		System.out.println(randomRange1020);
		return "OK!";
	}
	
	@RequestMapping("string")
	public void createRandomString(){
		/**
		 * 方法过时
		 */
		String tracingId = RandomStringUtils.randomAlphanumeric(12);
		
		/**
		 * 使用20个字母a-z随机字符串
		 */
        RandomStringGenerator generator1 = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
        String randomLetters = generator1.generate(20);
        /**
         * 共20个字符,中文在中间     ======随机字母字符串=======
         */
        System.out.println(StringUtils.center("随机字母字符串",20, "="));
        System.out.println(randomLetters);

        /**
         * 使用数字0-9的随机字符串
         */
        RandomStringGenerator generator2 = new RandomStringGenerator.Builder().withinRange('0', '9').build();
        String randomNumbers = generator2.generate(20);
        System.out.println(StringUtils.center("随机数字字符串",20, "="));
        System.out.println(randomNumbers);

        
        /**
         * 使用码位为0到z的随机字符串       
         */
        RandomStringGenerator generator3 = new RandomStringGenerator.Builder().withinRange('0', 'z').build();
        String random = generator3.generate(20);
        System.out.println(StringUtils.center("随机混合字符串",20, "="));
        System.out.println(random);
	}

}
