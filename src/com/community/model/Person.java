package com.community.model;
//��Ա����ʵ����
public class Person {
	private String name;//����
	private String sex;//�Ա�
	private String idno;//���֤
	private String birthday;//��������
	private String accountaddr;//���ڵ�ַ
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
