package com.community.model;
//ά���������ʵ����
public class Application {
	private String applicant;//������
	private String roomno;//�����˷�����
	private String applytime;//����ʱ��
	private String applyprogram;//ά����Ŀ
	private String applystate;//��ά��״̬���Ѵ���/δ����
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
