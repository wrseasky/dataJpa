package com.baidu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baidu.entity.IsDelete;


@Repository
public interface IsDelRepository extends JpaRepository<IsDelete, Integer> {


}
