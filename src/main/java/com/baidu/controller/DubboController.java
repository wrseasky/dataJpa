package com.baidu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.service.dubbo.CustomerService;

@RestController
public class DubboController {
//	@Autowired
//	private CustomerService customerService;
//
//	@RequestMapping(value = "/consumer", produces = "application/json;charset=utf-8")
//	public String dobbu() {
//		String name = customerService.getName();
//		return name;
//	}
}
