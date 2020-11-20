package com.community.model.login;

public class property {
	
	private int id;
	private String qu;
	private String dong;
	private String cheng;
	private String fang;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQu() {
		return qu;
	}
	public void setQu(String qu) {
		this.qu = qu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getCheng() {
		return cheng;
	}
	public void setCheng(String cheng) {
		this.cheng = cheng;
	}
	public String getFang() {
		return fang;
	}
	public void setFang(String fang) {
		this.fang = fang;
	}
	public property(String qu, String dong, String cheng, String fang) {
		super();
		this.qu = qu;
		this.dong = dong;
		this.cheng = cheng;
		this.fang = fang;
	}
	public property() {
	}
	
	
}
