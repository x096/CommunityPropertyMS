package com.community.model;
//欠费提醒实体类
public class Arrears {
	private String payno;//收费单编号
	private String payname;//收费项目名称
	private String unit;//单价
	private String total;//总价
	private String paytype;//收费项类型
	private String ownername;//业主姓名
	private String address;//房屋地址
	private String time;//时间
	public String getPayno() {
		return payno;
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
	public String getOwnername() {
		return ownername;
	}
	public String getAddress() {
		return address;
	}
	public String getTime() {
		return time;
	}
	public void setPayno(String payno) {
		this.payno = payno;
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
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Arrears(String payno, String payname, String unit, String total, String paytype, String ownername,
			String address, String time) {
		super();
		this.payno = payno;
		this.payname = payname;
		this.unit = unit;
		this.total = total;
		this.paytype = paytype;
		this.ownername = ownername;
		this.address = address;
		this.time = time;
	}
	public Arrears() {
		super();
	}
	public String toString() {
		return this.payno+"-"+this.payname+"-"+this.unit+"-"+this.total+"-"+this.paytype+"-"+this.ownername+"-"+this.address+"-"+this.time;
	}
	
}
