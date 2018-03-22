package com.baidu.service;


import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AService {

	@Transactional(propagation = Propagation.REQUIRED)
	public void a() {
		//this.b();
		((AService) AopContext.currentProxy()).b();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void b() {
	}
}
