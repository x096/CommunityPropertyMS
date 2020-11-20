package com.community.model.login;

public class Userinfo {

	/**
	 * 公司名
	 * 公司地址
	 * 公司邮编
	 * 身份证号
	 * 姓名
	 * 性别
	 * 邮编
	 */
	private int id;
	private String companyName;
	private String companyAddress;
	private String companyZip;
	private String idCade;
	private String name;
	private String sex;
	private String postbox;
	
	
	
	public Userinfo(String companyName, String companyAddress, String companyZip, String idCade, String name,
			String sex, String postbox) {
		super();
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyZip = companyZip;
		this.idCade = idCade;
		this.name = name;
		this.sex = sex;
		this.postbox = postbox;
	}

	public Userinfo() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyZip() {
		return companyZip;
	}
	public void setCompanyZip(String companyZip) {
		this.companyZip = companyZip;
	}
	public String getIdCade() {
		return idCade;
	}
	public void setIdCade(String idCade) {
		this.idCade = idCade;
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
	public String getPostbox() {
		return postbox;
	}
	public void setPostbox(String postbox) {
		this.postbox = postbox;
	}
	
	
}
