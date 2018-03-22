package com.baidu.logAspect;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.entity.Person;
import com.baidu.repository.PersonRepository;

@Service
public class LogService {
	@Autowired
	private PersonRepository personRepository;

	@Transactional
	@SystemServiceLog(description = Constants.ADMIN_SAVE_OPTIONS, tableType = Constants.ADMIN_TABLE_TYPE)
	public Object savePerson(String name, Integer version) throws Exception{
		
		
		throw new Exception("service whatever");
//		Person person = new Person();
//		person.setName(name);
//		person.setVersion(version);
//		return personRepository.save(person);
	}
}
