package com.baidu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface FindRepository<T> {

	Page<T> findAll(Specification<T> specification, Pageable pageable);
	
	List<T> findAll(Specification<T> specification);
	
	List<T> findAll(Specification<T> specification, Sort sort);
}
