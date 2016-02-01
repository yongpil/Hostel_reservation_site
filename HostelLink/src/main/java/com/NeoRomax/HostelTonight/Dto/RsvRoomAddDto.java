package com.NeoRomax.HostelTonight.Dto;

/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Dto
* 3. 파일명 : RsvRoomAddDto.java
* 4. 작성일 : 2016. 2. 1. 오후 2:34:17
* 5. 작성자 : nick
* 6. 설명 : 예약시 rervation_rooms를 추가하기 위한 DTO
* </pre>
*/
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
