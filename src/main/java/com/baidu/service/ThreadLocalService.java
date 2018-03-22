package com.baidu.service;

import org.springframework.stereotype.Service;

import com.baidu.utils.OtherUtils;

/**
* @author 作者 wr:
* @version 创建时间：2018年3月6日 上午11:53:52
* 类说明
*/
@Service
public class ThreadLocalService {

	public void thread(){
		Integer integer = OtherUtils.getThreadLocal().get();
		System.out.println(integer);
	}
}
