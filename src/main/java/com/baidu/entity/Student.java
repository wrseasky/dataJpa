package com.baidu.entity;

import javax.persistence.*;

import org.springframework.data.annotation.Version;

import java.io.Serializable;

@Entity
@Table(name="student")
public class Student implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sid;

    private String sname;

    //若有多个cascade，可以是：{CascadeType.PERSIST,CascadeType.MERGE}
    @ManyToOne(cascade={CascadeType.ALL}, optional = true)  //true 为left join
    @JoinColumn(name="classid")     //student表中对应外键的值：classid
    private Classes classes;

    @Version
    private Integer version;
    
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", classes=" + classes + ", version=" + version + "]";
	}

}