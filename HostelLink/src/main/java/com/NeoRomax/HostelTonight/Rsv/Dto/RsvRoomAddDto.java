package com.NeoRomax.HostelTonight.Rsv.Dto;

public class RsvRoomAddDto {
	private int rsvRoomsNum;
	private int rsvNum;
	private int roomNum;
	private int rsvRoomsRate;
	
	public RsvRoomAddDto(int rsvNum, int roomNum, int rsvRoomsRate) {
		super();
		this.rsvNum = rsvNum;
		this.roomNum = roomNum;
		this.rsvRoomsRate = rsvRoomsRate;
	}

	
	public int getRsvRoomsNum() {
		return rsvRoomsNum;
	}

	public void setRsvRoomsNum(int rsvRoomsNum) {
		this.rsvRoomsNum = rsvRoomsNum;
	}

	public int getRsvRoomsRate() {
		return rsvRoomsRate;
	}

	public void setRsvRoomsRate(int rsvRoomsRate) {
		this.rsvRoomsRate = rsvRoomsRate;
	}

	public int getRsvNum() {
		return rsvNum;
	}

	public void setRsvNum(int rsvNum) {
		this.rsvNum = rsvNum;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
}
