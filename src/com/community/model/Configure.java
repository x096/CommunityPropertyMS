package com.community.model;

public class Configure {
	private String id;//���
	private String name;//��������
	private String price;//�۸�
	private String Servicelife;//ʱ��
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPrice() {
		return price;
	}
	public String getServicelife() {
		return Servicelife;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setServicelife(String servicelife) {
		Servicelife = servicelife;
	}
	public Configure() {
		super();
	}
	public Configure(String id, String name, String price, String servicelife) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.Servicelife = servicelife;
	}
	public String toString() {
		return this.id+"-"+this.name+"-"+this.price+"-"+this.Servicelife;
	}
}
