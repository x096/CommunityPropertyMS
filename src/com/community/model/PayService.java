package com.community.model;

public class PayService {
	private String payno;//�շ�����
	private String payname;//�շ�������
	private String paytype;//�շ�������
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
