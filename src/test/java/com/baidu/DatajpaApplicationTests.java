package com.baidu;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.entity.Classes;
import com.baidu.entity.Person;
import com.baidu.entity.Student;
import com.baidu.repository.ClassesRepository;
import com.baidu.repository.PersonRepository;
import com.baidu.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement 
public class DatajpaApplicationTests {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ClassesRepository classesRepository;

	@Test
	public void contextLoads() {

		Classes classes = new Classes();
		classes.setName("access");

		Student st1 = new Student();
		st1.setSname("jason");
		st1.setClasses(classes);
		studentRepository.save(st1);

		Student st2 = new Student();
		st2.setSname("hwj");
		st2.setClasses(classes);
		studentRepository.save(st2);
	}

	@Test
	public void contex() {
		Student st1 = new Student();
		st1.setSname("jason");
		studentRepository.save(st1);

		Student st2 = new Student();
		st2.setSname("hwj");
		studentRepository.save(st2);

		Set<Student> students = new HashSet<Student>();
		students.add(st1);
		students.add(st2);

		Classes classes = new Classes();
		classes.setName("access");
		classes.setStudents(students);
		classesRepository.save(classes);
	}

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void tttt() {

		Person person1 = personRepository.findOne(1);
		Person person2 = personRepository.findOne(1);

		// 打印当前商品信息
		System.out.println(person1);
		System.out.println(person2);

		// 更新信息1
		person1.setName("测试1");
		Person save1 = personRepository.save(person1);
		System.out.println("修改信息1 " + save1);

		// 更新信息2
		person2.setName("测试2");
		Person save2 = personRepository.save(person2);
		System.out.println("修改信息2 " + save2);
	}

	
	@Test
	@Transactional
	public void ttttt() {

		Person person1 = personRepository.findOne(1);

		person1.setName("测试1");
		//Person save2 = personRepository.save(person1);
		//System.out.println("修改信息2 " + save2);
	}

	
	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	public void tttttt() {
		try {
			//entityManager.setFlushMode(FlushModeType.COMMIT); 
			//Person person = entityManager.find(Person.class, 1, LockModeType.OPTIMISTIC);
			entityManager.setFlushMode(FlushModeType.AUTO); 
			Person person = entityManager.find(Person.class, 1);
			System.out.println(person);
			person.setName("ttttttt");
			//entityManager.merge(person);
			entityManager.flush();
			//Person person1 = personRepository.findOne(1);
			//person1.setName("测试1");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Test
	@Transactional()
	public void tttttttttt() {
		Person person67 = entityManager.find(Person.class, 1L);
		person67.setName("person67");
		
		Person person66 = entityManager.find(Person.class, 2L);
		entityManager.lock(person66, LockModeType.OPTIMISTIC);
	}

}
