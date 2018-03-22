package com.baidu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.entity.AnotationEntity;
import com.baidu.repository.AnotationEntityRepository;

@RestController
@SuppressWarnings("all")
public class AnotationEntityController {
	
	@Autowired
	private AnotationEntityRepository anotationEntityRepository;
	
	@RequestMapping("/entity")
	public Object tttttttttttt() {
		
//		Assert.notNull(object);
		List<String> object = new ArrayList<String>();
		Assert.notEmpty(object);
		
		Assert.isNull(object, "");
		
		Assert.notNull(object, "");

		List<AnotationEntity> findAll = anotationEntityRepository.findAll();
		
		return findAll;
	}
	
	@RequestMapping("/ins")
	public Object ttttttttttt() {
		AnotationEntity anotationEntity = new AnotationEntity();
		anotationEntity.setName("name");
		anotationEntity.setAge(11);

		AnotationEntity save = anotationEntityRepository.save(anotationEntity);
		
		return save;
	}
}
