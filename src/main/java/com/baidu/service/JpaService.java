package com.baidu.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.controller.LogbackController;
import com.baidu.entity.Person;
import com.baidu.entity.StudentHibernateUtilsTest;
import com.baidu.repository.PersonRepository;
import com.baidu.utils.HibernateUtils;

@Service
@Transactional
public class JpaService {
	
	private static Logger logger = LoggerFactory.getLogger(JpaService.class);
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private PersonRepository personRepository;

	public void test() {
		Query query = entityManager.createNativeQuery("");
		query.setLockMode(LockModeType.PESSIMISTIC_FORCE_INCREMENT);
	}

	public void testt() {

		// Person person1 = entityManager.find(Person.class, 1);
		// person1.setName("111111");

		Person person = personRepository.findOne(1);
		person.setName("000");
		
		logger.info("log-shit");
	}
	
	/**
	 *  测试HibernateUtils.java
	 * 
	 */

	public List<StudentHibernateUtilsTest> select() {

		String sql = "select s.sid,s.sname from student s";
		Query query = entityManager.createNativeQuery(sql);
		query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List resultList = query.getResultList();
		List convertList = HibernateUtils.convertList(StudentHibernateUtilsTest.class, resultList);
		return convertList;
	}

	@SuppressWarnings("all")
	public StudentHibernateUtilsTest selectone() {

		String sql = "select s.sid,s.sname from student s where sid = 1";
		Query query = entityManager.createNativeQuery(sql);
		query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		Map<String, Object> singleResult = (Map<String, Object>) query.getSingleResult();
		StudentHibernateUtilsTest convertObject = HibernateUtils.convertObject(StudentHibernateUtilsTest.class, singleResult);
		return convertObject;
	}
}
