package com.baidu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baidu.entity.AnotationEntity;


@Repository
public interface AnotationEntityRepository extends JpaRepository<AnotationEntity, String> {


}
