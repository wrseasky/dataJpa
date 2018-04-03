package com.baidu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.entity.StudentHibernateUtilsTest;
import com.baidu.service.JpaService;

@RestController
public class JpaController {
	@Autowired
	private JpaService jpaService;

	@RequestMapping("/test")
	public void testt() {
		jpaService.testt();
	}
	
	@RequestMapping("/z")
	public Object z() {
		List<StudentHibernateUtilsTest> select = jpaService.select();
		return select;
	}
	
	@RequestMapping("/zz")
	public Object zz() {
		StudentHibernateUtilsTest select = jpaService.selectone();
		return select;
	}
	
	@RequestMapping("/home/{page}")
	public String homePages(@PathVariable String page, String v, HttpServletRequest request, HttpServletResponse response) {
		
		return page + v;
	}
}
