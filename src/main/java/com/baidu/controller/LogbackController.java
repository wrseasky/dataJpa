package com.baidu.controller;

import org.apache.commons.text.RandomStringGenerator;
import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.service.JpaService;

@RestController
public class LogbackController {
	private static Logger logger = LoggerFactory.getLogger(LogbackController.class);

	@Autowired
	private JpaService jpaService;
	
	@RequestMapping("/logback")
	public void test() {
		logger.trace("======trace");   
		logger.debug("======debug");
		logger.info("======info");
		logger.warn("======warn");
		logger.error("======error");
		
		RandomStringGenerator rsg = new RandomStringGenerator.Builder().withinRange('a','z').build();
		String generate = rsg.generate(10);
		MDC.put("mdc_trace_id", generate);
		logger.warn("{} - Heartbeat status: {}", "first", "second");
		
		jpaService.testt();
	}
}
