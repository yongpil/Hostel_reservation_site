package com.NeoRomax.HostelTonight.Dto;

/**
* <pre>
* 1. ������Ʈ�� : HostelTonight
* 2. ��Ű����(�Ǵ� ���丮 ���) : com.NeoRomax.HostelTonight.Dto
* 3. ���ϸ� : RsvRoomAddDto.java
* 4. �ۼ��� : 2016. 2. 1. ���� 2:34:17
* 5. �ۼ��� : nick
* 6. ���� : ����� rervation_rooms�� �߰��ϱ� ���� DTO
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
