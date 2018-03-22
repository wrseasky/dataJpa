package com.baidu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baidu.entity.Cat;


@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {


}
