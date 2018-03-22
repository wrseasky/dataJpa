package com.baidu.logAspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

	@Autowired
	private LogService logService;

	@RequestMapping("/log")
	public Object savePerson() throws Exception {

		return logService.savePerson("张三", 1);
	}
}
