package com.baidu.excepAspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
//	private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);
//
//	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
//	private void pointcut() {
//
//	}
//
//	@AfterThrowing(pointcut = "pointcut()", throwing = "e")
//	public void handle(Exception e) {
//		logger.info(e.getMessage());
//
//	}
}
