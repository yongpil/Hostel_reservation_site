package com.NeoRomax.HostelTonight.Dto;


/**
* <pre>
* 1. ������Ʈ�� : HostelTonight
* 2. ��Ű����(�Ǵ� ���丮 ���) : com.NeoRomax.HostelTonight.Dto
* 3. ���ϸ� : RsvAddDto.java
* 4. �ۼ��� : 2016. 2. 1. ���� 2:19:36
* 5. �ۼ��� : nick
* 6. ���� : ������ ���� DTO
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
