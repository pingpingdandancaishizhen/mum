package org.wangguang.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tbl_user")
@PrimaryKeyJoinColumn(name = "id")
public class User implements Serializable{

	private static final long serialVersionUID = 7419229779731522702L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int age;
    private Date datetime;

    public int getAge() {
        return age;
    }

    public Date getDatetime() {
        return datetime;
    }

   

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

  

    public void setName(String name) {
        this.name = name;
    }

}
