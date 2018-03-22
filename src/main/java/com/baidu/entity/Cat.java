package com.baidu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "cat")
@Entity
public class Cat {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@OneToOne(cascade = { CascadeType.ALL }, optional = true, mappedBy = "cat") // 左外连接
	private IDCard idCard;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IDCard getIDCard() {
		return idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IDCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}

}
