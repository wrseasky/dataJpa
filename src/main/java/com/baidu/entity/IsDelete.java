package com.baidu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "test.is_delete")
@Entity
public class IsDelete {
	@Id
	@GeneratedValue
	private Integer id;
	private boolean isDel;
	private String isFunny = "";
	private boolean test;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isDel() {
		return isDel;
	}

	public void setDel(boolean isDel) {
		this.isDel = isDel;
	}

	public String getIsFunny() {
		return isFunny;
	}

	public void setIsFunny(String isFunny) {
		this.isFunny = isFunny;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

}
