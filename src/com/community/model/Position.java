package com.community.model;
//ְλ����ʵ����
public class Position {
	private String jobtitle;//ְλ����
	private String positionnote;//ְλ��ע
	public String getJobtitle() {
		return jobtitle;
	}
	public String getPositionnote() {
		return positionnote;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public void setPositionnote(String positionnote) {
		this.positionnote = positionnote;
	}
	public Position(String jobtitle, String positionnote) {
		super();
		this.jobtitle = jobtitle;
		this.positionnote = positionnote;
	}
	public Position() {
		super();
	}
	@Override
	public String toString() {
		return this.jobtitle+"-"+this.positionnote;
	}
}
