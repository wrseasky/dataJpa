package com.baidu.service.shiwu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.entity.Cat;
import com.baidu.entity.IsDelete;
import com.baidu.repository.CatRepository;
import com.baidu.repository.IsDelRepository;

/**
* @author 作者 wr:
* @version 创建时间：2018年2月9日 上午11:28:23
* 类说明
*/
@Service
@Transactional
public class ShiwuService {

	@Autowired
	private CatRepository catRepository;
	
	@Autowired
	private IsDelRepository isDelRepository;
	
	
	public void ss(){
		Cat cat = new Cat();
		cat.setName("shiyan");
		catRepository.save(cat);
		
		IsDelete delete = new IsDelete();
		delete.setIsFunny("fun");
		isDelRepository.save(delete);
		
		int a = 1/0;
		
	}
}
