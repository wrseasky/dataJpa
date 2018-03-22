package com.baidu.excepAspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
	@Autowired
	private ExceptionService exceptionService;
	@RequestMapping("textException")
	public void testExceptionAspect() throws Exception {
		exceptionService.testExceptionAspect();
	}
}
