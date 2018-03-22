package com.baidu.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.service.ThreadLocalService;
import com.baidu.utils.OtherUtils;

/**
* @author 作者 wr:
* @version 创建时间：2018年3月6日 上午11:52:34
* 类说明
*/
@RestController
public class ThreadLocalController {
	
	@Autowired
	private ThreadLocalService threadLocalService;
	
	@RequestMapping("/thread")
	public void thread(){
		OtherUtils.getThreadLocal().set(1);
		threadLocalService.thread();
		
	}
	
	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal("");
	}
}
