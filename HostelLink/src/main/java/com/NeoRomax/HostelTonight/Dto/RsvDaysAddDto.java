package com.NeoRomax.HostelTonight.Dto;

import java.sql.Date;


/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Dto
* 3. 파일명 : RsvDaysAddDto.java
* 4. 작성일 : 2016. 2. 1. 오후 2:20:27
* 5. 작성자 : nick
* 6. 설명 : sessionDTO에서 예약 날짜를 위한 DTO
* </pre>
*/
public class RsvDaysAddDto {
	private int rsvDaysNum;
	private Date rsvDays;
	private int rsvRoomsNum;
	private String hostelCity;
	
	public RsvDaysAddDto(Date rsvDays, int rsvRoomsNum, String hostelCity) {
		super();
		this.rsvDays = rsvDays;
		this.rsvRoomsNum = rsvRoomsNum;
		this.hostelCity = hostelCity;
	}

	public int getRsvDaysNum() {
		return rsvDaysNum;
	}

	public void setRsvDaysNum(int rsvDaysNum) {
		this.rsvDaysNum = rsvDaysNum;
	}

	public Date getRsvDays() {
		return rsvDays;
	}

	public void setRsvDays(Date rsvDays) {
		this.rsvDays = rsvDays;
	}

	public int getRsvRoomsNum() {
		return rsvRoomsNum;
	}

	public void setRsvRoomsNum(int rsvRoomsNum) {
		this.rsvRoomsNum = rsvRoomsNum;
	}

	public String getHostelCity() {
		return hostelCity;
	}

	public void setHostelCity(String hostelCity) {
		this.hostelCity = hostelCity;
	}
	
	
	
	
}
