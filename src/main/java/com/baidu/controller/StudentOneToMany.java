package com.baidu.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.entity.Classes;
import com.baidu.entity.Student;
import com.baidu.repository.ClassesRepository;
import com.baidu.repository.StudentRepository;

@RestController
public class StudentOneToMany {
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ClassesRepository classesRepository;
	
	@RequestMapping("/find")
	public void tttttttttttt() {

		Student st1 = studentRepository.findOne(5);
		System.out.println(st1);
		
	}

	@RequestMapping("/t")
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

	@RequestMapping("/tt")
	public String contex() {
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
		return "";
	}
	
	@RequestMapping("/left")
	public String left() {
		List<Student> findAll = studentRepository.findAll();
		for (Student student : findAll) {
			System.out.println(student);
		}
		return "shenme";
	}
	
	@RequestMapping("/cla")
	public String classes() {
		List<Classes> findAll2 = classesRepository.findAll();
		for (Classes classes : findAll2) {
			System.out.println(classes);
		}
		return "";
	}
}
