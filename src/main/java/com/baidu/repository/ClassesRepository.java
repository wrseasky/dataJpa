package com.baidu.repository;

import com.baidu.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassesRepository extends JpaRepository<Classes, Integer> {


}
