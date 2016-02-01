package com.NeoRomax.HostelTonight.Dto;

import java.sql.Date;

/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Dto
* 3. 파일명 : RsvAvailableDto.java
* 4. 작성일 : 2016. 2. 1. 오후 2:19:49
* 5. 작성자 : nick
* 6. 설명 : 예약 가능한 객실 정보를 담기 우한 DTO
* </pre>
*/
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
