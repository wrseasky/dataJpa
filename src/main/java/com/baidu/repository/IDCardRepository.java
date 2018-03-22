package com.baidu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baidu.entity.IDCard;


@Repository
public interface IDCardRepository extends JpaRepository<IDCard, Integer> {


}
