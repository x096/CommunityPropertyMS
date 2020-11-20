package com.community.model;

public class PayNote {
	private String pnoteno;//�շѵ����
	private String payname;//�շ���Ŀ����
	private String unit;//����
	private String total;//�ܼ�
	private String paytype;//�շ���Ŀ����
	private String ownerName;//ҵ������
	private String address;//���ݵ�ַ
	
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
