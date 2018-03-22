package com.baidu.entity;

import javax.persistence.*;

import org.springframework.data.annotation.Version;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="classes")
public class Classes implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO) //自动选择主键生成策略，以适应不同的数据库移植。
    private int id;
    private String name;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="classes") //@OneToMany当前类和此属性关系
    private Set<Student> students;
    
    @Version
    private Integer version;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", version=" + version + "]";
	}
}
