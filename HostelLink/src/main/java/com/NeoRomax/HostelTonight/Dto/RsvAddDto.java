package com.NeoRomax.HostelTonight.Dto;

public class RsvAddDto {
	private int hostelNum;
	private String userId;
	private int totalRate;
	private int rsvNum;
	
	public RsvAddDto() {
		super();
	}

	public RsvAddDto(int hostelNum, String userId, int totalRate) {
		super();
		this.hostelNum = hostelNum;
		this.userId = userId;
		this.totalRate = totalRate;
	}

	public int getHostelNum() {
		return hostelNum;
	}

	public void setHostelNum(int hostelNum) {
		this.hostelNum = hostelNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(int totalRate) {
		this.totalRate = totalRate;
	}

	public int getRsvNum() {
		return rsvNum;
	}

	public void setRsvNum(int rsvNum) {
		this.rsvNum = rsvNum;
	}
	
	
	
}
