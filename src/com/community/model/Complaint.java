package com.community.model;
//Ͷ�߹���ʵ����
public class Complaint {
	private String complainant;//Ͷ����
	private String roomno;//Ͷ���˷�����
	private String complainttime;//Ͷ��ʱ��
	private String matter;//Ͷ������
	private String state;//����״̬���Ѵ���/δ����
	public String getComplainant() {
		return complainant;
	}
	public String getRoomno() {
		return roomno;
	}
	public String getComplainttime() {
		return complainttime;
	}
	public String getMatter() {
		return matter;
	}
	public String getState() {
		return state;
	}
	public void setComplainant(String complainant) {
		this.complainant = complainant;
	}
	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
	public void setComplainttime(String complainttime) {
		this.complainttime = complainttime;
	}
	public void setMatter(String matter) {
		this.matter = matter;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Complaint(String complainant, String roomno, String complainttime, String matter, String state) {
		super();
		this.complainant = complainant;
		this.roomno = roomno;
		this.complainttime = complainttime;
		this.matter = matter;
		this.state = state;
	}
	public Complaint() {
		super();
	}
	@Override
	public String toString() {
		return this.complainant+"-"+this.roomno+"-"+this.complainttime+"-"+this.matter+"-"+this.state;
	}

}
