package com.community.model;

public class PayNote {
	private String pnoteno;//收费单编号
	private String payname;//收费项目名称
	private String unit;//单价
	private String total;//总价
	private String paytype;//收费项目类型
	private String ownerName;//业主姓名
	private String address;//房屋地址
	
	public String getPnoteno() {
		return pnoteno;
	}

	public String getPayname() {
		return payname;
	}

	public String getUnit() {
		return unit;
	}

	public String getTotal() {
		return total;
	}

	public String getPaytype() {
		return paytype;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getAddress() {
		return address;
	}

	public void setPnoteno(String pnoteno) {
		this.pnoteno = pnoteno;
	}

	public void setPayname(String payname) {
		this.payname = payname;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PayNote() {
		super();
	}

	public PayNote(String pnoteno, String payname, String unit, String total, String paytype, String ownerName,
			String address) {
		super();
		this.pnoteno = pnoteno;
		this.payname = payname;
		this.unit = unit;
		this.total = total;
		this.paytype = paytype;
		this.ownerName = ownerName;
		this.address = address;
	}

	public String toString() {
		return this.pnoteno+"-"+this.payname+"-"+this.unit+"-"+this.total+"-"+this.paytype+"-"+this.ownerName+"-"+this.address;
	}
}
