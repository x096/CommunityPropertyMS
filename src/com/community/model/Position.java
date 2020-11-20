package com.community.model;
//职位管理实体类
public class Position {
	private String jobtitle;//职位名称
	private String positionnote;//职位备注
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
