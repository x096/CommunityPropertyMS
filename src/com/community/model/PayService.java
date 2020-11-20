package com.community.model;

public class PayService {
	private String payno;//收费项编号
	private String payname;//收费项名称
	private String paytype;//收费项类型
	public String getPayno() {
		return payno;
	}
	public String getPayname() {
		return payname;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPayno(String payno) {
		this.payno = payno;
	}
	public void setPayname(String payname) {
		this.payname = payname;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String toString() {
		return this.payno+"-"+this.payname+"-"+this.paytype;
	}
	public PayService(String payno, String payname, String paytype) {
		super();
		this.payno = payno;
		this.payname = payname;
		this.paytype = paytype;
	}
	public PayService() {
		super();
	}
	
}
