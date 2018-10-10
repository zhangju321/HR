package com.aaa.entity;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PerSon {
private int id;
private String name;
private String sex;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date birthday;
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
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public PerSon(int id, String name, String sex, Date birthday) {
	super();
	this.id = id;
	this.name = name;
	this.sex = sex;
	this.birthday = birthday;
}
public PerSon() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "PerSon [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + "]";
}

}
