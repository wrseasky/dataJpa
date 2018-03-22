package com.baidu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.entity.Person;


@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Integer> {


}
