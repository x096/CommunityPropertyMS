package com.community.model;
//Ƿ������ʵ����
public class Arrears {
	private String payno;//�շѵ����
	private String payname;//�շ���Ŀ����
	private String unit;//����
	private String total;//�ܼ�
	private String paytype;//�շ�������
	private String ownername;//ҵ������
	private String address;//���ݵ�ַ
	private String time;//ʱ��
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
