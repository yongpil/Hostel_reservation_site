package com.NeoRomax.HostelTonight.Dto;

/**
* <pre>
* 1. ������Ʈ�� : HostelTonight
* 2. ��Ű����(�Ǵ� ���丮 ���) : com.NeoRomax.HostelTonight.Dto
* 3. ���ϸ� : HostelDto.java
* 4. �ۼ��� : 2016. 2. 1. ���� 2:16:17
* 5. �ۼ��� : nick
* 6. ���� : ȣ���� ������ ��� �ִ� Dto
* </pre>
*/
public class HostelDto {
	private int hostelNum;
	private String hostelName;
	private String hostelNation;
	private String hostelCity;
	private String hostelAddr;
	private String hostelInfo;
	private String hostelPhone;
	private String hostelEmail;
	
	
	public HostelDto() {
		super();
	}

	public HostelDto(String hostelName, String hostelNation, String hostelCity, String hostelAddr, String hostelInfo,
			String hostelPhone, String hostelEmail) {
		super();
		this.hostelName = hostelName;
		this.hostelNation = hostelNation;
		this.hostelCity = hostelCity;
		this.hostelAddr = hostelAddr;
		this.hostelInfo = hostelInfo;
		this.hostelPhone = hostelPhone;
		this.hostelEmail = hostelEmail;
	}
	
	public int getHostelNum() {
		return hostelNum;
	}
	public void setHostelNum(int hostelNum) {
		this.hostelNum = hostelNum;
	}
	public String getHostelName() {
		return hostelName;
	}
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}
	public String getHostelNation() {
		return hostelNation;
	}
	public void setHostelNation(String hostelNation) {
		this.hostelNation = hostelNation;
	}
	public String getHostelCity() {
		return hostelCity;
	}
	public void setHostelCity(String hostelCity) {
		this.hostelCity = hostelCity;
	}
	public String getHostelAddr() {
		return hostelAddr;
	}
	public void setHostelAddr(String hostelAddr) {
		this.hostelAddr = hostelAddr;
	}
	public String getHostelInfo() {
		return hostelInfo;
	}
	public void setHostelInfo(String hostelInfo) {
		this.hostelInfo = hostelInfo;
	}
	public String getHostelPhone() {
		return hostelPhone;
	}
	public void setHostelPhone(String hostelPhone) {
		this.hostelPhone = hostelPhone;
	}
	public String getHostelEmail() {
		return hostelEmail;
	}
	public void setHostelEmail(String hostelEmail) {
		this.hostelEmail = hostelEmail;
	}

	
	
}
