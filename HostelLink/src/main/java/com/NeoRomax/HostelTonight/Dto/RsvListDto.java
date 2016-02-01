
package com.NeoRomax.HostelTonight.Dto;

import java.util.ArrayList;

/**
 * <PRE>
 * 1. FileName  : RscRoomListDto.java
 * 2. Package  : com.NeoRomax.HostelTonight.Rsv.Dto
 * 3. Comment  : hostel_detail.jsp���� jstl�� ȭ�鿡 ���ϰ� �Ѹ������� ���� DTO
 * 4. �ۼ���   : "Yong Pil Moon"
 * 5. �ۼ���   : 2015. 11. 27. ���� 2:52:04
 * </PRE>
 */

public class RsvListDto {
	private int roomsNum;
	private String roomsName;
	private String roomsInfo;
	private ArrayList<RsvAvailableDto> tRsvAvailableDtos;
	public int getRoomsNum() {
		return roomsNum;
	}
	public void setRoomsNum(int roomsNum) {
		this.roomsNum = roomsNum;
	}
	public String getRoomsName() {
		return roomsName;
	}
	public void setRoomsName(String roomsName) {
		this.roomsName = roomsName;
	}
	public String getRoomsInfo() {
		return roomsInfo;
	}
	public void setRoomsInfo(String roomsInfo) {
		this.roomsInfo = roomsInfo;
	}
	public ArrayList<RsvAvailableDto> gettRsvAvailableDtos() {
		return tRsvAvailableDtos;
	}
	public void settRsvAvailableDtos(ArrayList<RsvAvailableDto> tRsvAvailableDtos) {
		this.tRsvAvailableDtos = tRsvAvailableDtos;
	}
	

	
}
