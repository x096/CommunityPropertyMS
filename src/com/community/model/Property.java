package com.community.model;
//¥��ʵ����
public class Property {
	private String block;//��
	private String building;//��
	private String floor;//��
	private String roomNo;//����
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
