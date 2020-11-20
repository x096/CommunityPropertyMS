package com.community.model;
//投诉管理实体类
public class Complaint {
	private String complainant;//投诉人
	private String roomno;//投诉人房间编号
	private String complainttime;//投诉时间
	private String matter;//投诉事项
	private String state;//处理状态（已处理/未处理）
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
