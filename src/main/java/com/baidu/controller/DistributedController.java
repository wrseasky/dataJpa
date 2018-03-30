package com.baidu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.service.distributedTrand.DistributedService;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月30日 下午2:10:56 类说明
 */
@RestController
public class DistributedController {

	@Autowired
	private DistributedService distributedService;

	@RequestMapping("/distri")
	public void distribute() {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					distributedService.get();
				}
			}).start();
		}
	}

}
