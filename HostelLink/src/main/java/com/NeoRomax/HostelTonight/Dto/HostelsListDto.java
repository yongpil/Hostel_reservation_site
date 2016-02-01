package com.NeoRomax.HostelTonight.Dto;

/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Dto
* 3. 파일명 : HostelsListDto.java
* 4. 작성일 : 2016. 2. 1. 오후 2:16:36
* 5. 작성자 : nick
* 6. 설명 : 호스텔 정보 와 해당 호스텔의 사진 정보를 담고 있는 DTO
* </pre>
*/
public class HostelsListDto {
	
	private int hostelNum;
	private String hostelName;
	private String hostelNation;
	private String hostelCity;
	private String hostelAddr;
	private String hostelInfo;
	private String hostelPhone;
	private String hostelEmail;
	private String imageName;
	
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
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


}
