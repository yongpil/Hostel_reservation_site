package com.NeoRomax.HostelTonight.Dto;

import java.sql.Date;

public class RsvAvailableDto {
	
	private Date rsvDate;
	private int rsvRoom;
	private int rsvAble;
	private int rsvHostelNum;
	private int rsvRate;
	public Date getRsvDate() {
		return rsvDate;
	}
	public void setRsvDate(Date rsvDate) {
		this.rsvDate = rsvDate;
	}
	public int getRsvRoom() {
		return rsvRoom;
	}
	public void setRsvRoom(int rsvRoom) {
		this.rsvRoom = rsvRoom;
	}
	public int getRsvAble() {
		return rsvAble;
	}
	public void setRsvAble(int rsvAble) {
		this.rsvAble = rsvAble;
	}
	public int getRsvHostelNum() {
		return rsvHostelNum;
	}
	public void setRsvHostelNum(int rsvHostelNum) {
		this.rsvHostelNum = rsvHostelNum;
	}
	public int getRsvRate() {
		return rsvRate;
	}
	public void setRsvRate(int rsvRate) {
		this.rsvRate = rsvRate;
	}

	

}
