package com.NeoRomax.HostelTonight.Dto;


/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Dto
* 3. 파일명 : RsvAddDto.java
* 4. 작성일 : 2016. 2. 1. 오후 2:19:36
* 5. 작성자 : nick
* 6. 설명 : 예약을 위한 DTO
* </pre>
*/
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
