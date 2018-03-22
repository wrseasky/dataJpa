package com.baidu.excepAspect;

import org.springframework.stereotype.Service;

@Service
public class ExceptionService {
	public void testExceptionAspect() throws Exception{
		int a = 1;
		int b = 0;
		System.out.println(a / b);
	}
}
