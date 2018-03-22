package com.baidu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.entity.IsDelete;
import com.baidu.repository.IsDelRepository;

@RestController
@SuppressWarnings("all")
public class IsDelController {
	
	@Autowired
	private IsDelRepository isDelRepository;
	
	@RequestMapping("/isdel")
	public Object tttttttttttt() {

		List<IsDelete> findAll = isDelRepository.findAll();
		
		return findAll;
	}
	
	@RequestMapping("/ad")
	public Object ttttttttttt() {
		IsDelete isDelete = new IsDelete();
		isDelete.setDel(true);
		isDelete.setTest(true);
		IsDelete save = isDelRepository.save(isDelete);
		return save;
	}
}
