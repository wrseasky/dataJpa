package com.baidu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.entity.Cat;
import com.baidu.entity.IDCard;
import com.baidu.repository.CatRepository;
import com.baidu.repository.IDCardRepository;

@RestController
@SuppressWarnings("all")
public class CatOneToOne {
	
	@Autowired
	private CatRepository catRepository;
	@Autowired
	private IDCardRepository iDCardRepository;
	
	@RequestMapping("/hel")
	public String get(){
		return "hello";
	}
	
	@RequestMapping("/one")
	public Object tttttttttttt() {

		List<Cat> findAll = catRepository.findAll();
		for (Cat cat : findAll) {
			System.out.println(cat);
			cat.getIDCard().setCat(null);
		}
		return findAll;
	}
	
	@RequestMapping("/onee")
	public void t() {

		List<IDCard> findAll = iDCardRepository.findAll();
		for (IDCard idCard : findAll) {
			System.out.println();
		}
	}

	@RequestMapping("/findid")
	public Object findbyid(Integer id) {

		Cat one = catRepository.findOne(id);

		one.getIDCard().setCat(null);
		return one;
	}
}
