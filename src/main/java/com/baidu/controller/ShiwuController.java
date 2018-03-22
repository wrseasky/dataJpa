package com.baidu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.service.shiwu.ShiwuService;
import org.springframework.web.bind.annotation.RestController;

/**
* @author 作者 wr:
* @version 创建时间：2018年2月9日 上午11:32:13
* 类说明
*/
@RestController
public class ShiwuController {
@Autowired
private ShiwuService shiwuService;
	@RequestMapping("shi")
	public void cc(){
		shiwuService.ss();
	}
}
