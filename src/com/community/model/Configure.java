package com.community.model;

public class Configure {
	private String id;//编号
	private String name;//配置名称
	private String price;//价格
	private String Servicelife;//时限
	
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
