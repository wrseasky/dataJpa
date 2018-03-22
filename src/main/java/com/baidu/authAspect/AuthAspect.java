package com.baidu.authAspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class AuthAspect implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
	}

}
