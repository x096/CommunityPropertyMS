package com.community.model;
//维修申请管理实体类
public class Application {
	private String applicant;//申请人
	private String roomno;//申请人房间编号
	private String applytime;//申请时间
	private String applyprogram;//维修项目
	private String applystate;//申维修状态（已处理/未处理）
	public String getApplicant() {
		return applicant;
	}
	public String getRoomno() {
		return roomno;
	}
	public String getApplytime() {
		return applytime;
	}
	public String getApplyprogram() {
		return applyprogram;
	}
	public String getApplystate() {
		return applystate;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}
	public void setApplyprogram(String applyprogram) {
		this.applyprogram = applyprogram;
	}
	public void setApplystate(String applystate) {
		this.applystate = applystate;
	}
	public Application(String applicant, String roomno, String applytime, String applyprogram, String applystate) {
		super();
		this.applicant = applicant;
		this.roomno = roomno;
		this.applytime = applytime;
		this.applyprogram = applyprogram;
		this.applystate = applystate;
	}
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return this.applicant+"-"+this.roomno+"-"+this.applytime+"-"+this.applyprogram+"-"+this.applystate;
	}
}
