package com.community.model;
//��λʵ����
public class ParkingLot {
	private String plno;//��λ���
	private String ownerno;//ҵ�����
	private String pltype;//��λ����
	private String plstate;//����λ״̬

	public String getPlno() {
		return plno;
	}

	public String getOwnerno() {
		return ownerno;
	}

	public String getPltype() {
		return pltype;
	}

	public String getPlstate() {
		return plstate;
	}

	public void setPlno(String plno) {
		this.plno = plno;
	}

	public void setOwnerno(String ownerno) {
		this.ownerno = ownerno;
	}

	public void setPltype(String pltype) {
		this.pltype = pltype;
	}

	public void setPlstate(String plstate) {
		this.plstate = plstate;
	}

	public ParkingLot(String plno, String ownerno, String pltype, String plstate) {
		super();
		this.plno = plno;
		this.ownerno = ownerno;
		this.pltype = pltype;
		this.plstate = plstate;
	}

	public ParkingLot() {
		super();
	}

	public String toString() {
		return this.plno+"-"+this.ownerno+"-"+this.pltype+"-"+this.plstate;
	}
	
}
