package com.baidu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.entity.StudentHibernateUtilsTest;
import com.baidu.service.TestService;

@RestController
public class TestController {
	@Autowired
	private TestService testService;

	@RequestMapping("/test")
	public void testt() {
		testService.testt();
	}
	
	@RequestMapping("/z")
	public Object z() {
		List<StudentHibernateUtilsTest> select = testService.select();
		return select;
	}
	
	@RequestMapping("/zz")
	public Object zz() {
		StudentHibernateUtilsTest select = testService.selectone();
		return select;
	}
	
	@RequestMapping("/home/{page}")
	public String homePages(@PathVariable String page, String v, HttpServletRequest request, HttpServletResponse response) {
		
		return page + v;
	}
}
