package com.NeoRomax.HostelTonight.Rsv.Dto;

import java.sql.Date;

public class RsvDaysAddDto {
	private int rsvDaysNum;
	private Date rsvDays;
	private int rsvRoomsNum;
	
	public RsvDaysAddDto(Date rsvDays, int rsvRoomsNum) {
		super();
		this.rsvDays = rsvDays;
		this.rsvRoomsNum = rsvRoomsNum;
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
	
	
	
	
}
