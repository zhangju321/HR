package com.aaa.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Person {
private Integer id;
private String name;
private Integer age;
private String sex;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date birthday;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
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
public Person(Integer id, String name, Integer age, String sex, Date birthday) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.sex = sex;
	this.birthday = birthday;
}
public Person() {
	super();
	
}
@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", birthday=" + birthday + "]";
}

}
