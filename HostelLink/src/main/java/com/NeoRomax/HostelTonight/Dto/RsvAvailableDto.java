package com.NeoRomax.HostelTonight.Dto;

import java.sql.Date;

/**
* <pre>
* 1. ������Ʈ�� : HostelTonight
* 2. ��Ű����(�Ǵ� ���丮 ���) : com.NeoRomax.HostelTonight.Dto
* 3. ���ϸ� : RsvAvailableDto.java
* 4. �ۼ��� : 2016. 2. 1. ���� 2:19:49
* 5. �ۼ��� : nick
* 6. ���� : ���� ������ ���� ������ ��� ���� DTO
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
