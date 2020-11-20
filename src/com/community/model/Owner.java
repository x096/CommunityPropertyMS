package com.community.model;
//业主实体类
public class Owner {
	private String roomNo;//房间编号
	private String ownerNo;//业主编号
	private String ownerName;//业主名
	private String ownerPhone;//业主联系方式
	
	public String getRoomNo() {
		return roomNo;
	}
	
	public String getOwnerNo() {
		return ownerNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}
	
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	
	public void setOwnerNo(String ownerNo) {
		this.ownerNo = ownerNo;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public Owner( String roomNo,String ownerNo, String ownerName, String ownerPhone) {
		super();
		this.roomNo = roomNo;
		this.ownerNo = ownerNo;
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
	}

	public Owner() {
		super();
	}

	public String toString() {
		return this.roomNo+"-"+this.ownerNo+"-"+this.ownerName+"-"+this.ownerPhone;
	}
}
