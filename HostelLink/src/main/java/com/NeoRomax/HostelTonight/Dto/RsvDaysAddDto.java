package com.NeoRomax.HostelTonight.Dto;

import java.sql.Date;

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
