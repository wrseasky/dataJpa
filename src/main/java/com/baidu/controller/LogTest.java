package com.baidu.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTest {
	private static Logger logger = Logger.getLogger(LogTest.class);

	@RequestMapping("/testlog")
	public void test() {
		System.out.println("===============");
		logger.trace("======trace");   
		logger.debug("======debug");
		logger.info("======info");
		logger.warn("======warn");
		logger.error("======error");
	}
}
