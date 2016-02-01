package com.NeoRomax.HostelTonight.Dto;

import java.util.ArrayList;
import java.util.List;

import com.NeoRomax.HostelTonight.Dto.HostelDto;
import com.NeoRomax.HostelTonight.Dto.RoomsDto;

/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Dto
* 3. 파일명 : RsvSessionDto.java
* 4. 작성일 : 2016. 2. 1. 오후 3:07:52
* 5. 작성자 : nick
* 6. 설명 : 예약 전 예약 내용확인, 얘약 기능을 위한 DTO 
* </pre>
*/
public class RsvSessionDto {

	private ArrayList<ArrayList<String>> rsvDatesList; //사용자가 선택한 객실의 날짜
	private ArrayList<ArrayList<String>> rsvRatesList; //사용자가 선택한 객실의 가격
	private HostelDto hostelDto; 
	private List<RoomsDto> roomList;//호스텔의 전체 객실 리스트
	private int totalRate; //총 예약 비용
	private String userId;
	
	public RsvSessionDto() {
		super();
	}

	public RsvSessionDto(ArrayList<ArrayList<String>> rsvDatesList, ArrayList<ArrayList<String>> rsvRatesList,
			HostelDto hostelDto, List<RoomsDto> roomList, int totalRate, String userId) {
		this.rsvDatesList = rsvDatesList;
		this.rsvRatesList = rsvRatesList;
		this.hostelDto = hostelDto;
		this.roomList = roomList;
		this.totalRate = totalRate;
		this.userId = userId;
	}

	public ArrayList<ArrayList<String>> getRsvDatesList() {
		return rsvDatesList;
	}

	public void setRsvDatesList(ArrayList<ArrayList<String>> rsvDatesList) {
		this.rsvDatesList = rsvDatesList;
	}

	public ArrayList<ArrayList<String>> getRsvRatesList() {
		return rsvRatesList;
	}

	public void setRsvRatesList(ArrayList<ArrayList<String>> rsvRatesList) {
		this.rsvRatesList = rsvRatesList;
	}

	public HostelDto getHostelDto() {
		return hostelDto;
	}

	public void setHostelDto(HostelDto hostelDto) {
		this.hostelDto = hostelDto;
	}

	public List<RoomsDto> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<RoomsDto> roomList) {
		this.roomList = roomList;
	}

	public int getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(int totalRate) {
		this.totalRate = totalRate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
}
