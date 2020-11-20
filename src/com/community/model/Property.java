package com.community.model;
//楼盘实体类
public class Property {
	private String block;//区
	private String building;//栋
	private String floor;//层
	private String roomNo;//房间
	public String getBlock() {
		return block;
	}
	public String getBuilding() {
		return building;
	}
	public String getFloor() {
		return floor;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String toString() {
		return this.block+"-"+this.building+"-"+this.floor+"-"+this.roomNo;
	}
	public Property(String block, String building, String floor, String roomNo) {
		super();
		this.block = block;
		this.building = building;
		this.floor = floor;
		this.roomNo = roomNo;
	}
	public Property() {
		super();
	}
	
	

}
