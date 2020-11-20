package com.community.model;
//人员管理实体类
public class Person {
	private String name;//姓名
	private String sex;//性别
	private String idno;//身份证
	private String birthday;//出生日期
	private String accountaddr;//户口地址
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getIdno() {
		return idno;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getAccountaddr() {
		return accountaddr;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setAccountaddr(String accountaddr) {
		this.accountaddr = accountaddr;
	}
	public Person(String name, String sex, String idno, String birthday, String accountaddr) {
		super();
		this.name = name;
		this.sex = sex;
		this.idno = idno;
		this.birthday = birthday;
		this.accountaddr = accountaddr;
	}
	public Person() {
		super();
	}
	public String toString() {
		return this.name+"-"+this.sex+"-"+this.idno+"-"+this.birthday+"-"+this.accountaddr;
	}
}
