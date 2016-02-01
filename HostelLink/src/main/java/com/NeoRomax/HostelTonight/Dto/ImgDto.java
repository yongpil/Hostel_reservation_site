package com.NeoRomax.HostelTonight.Dto;

/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Dto
* 3. 파일명 : ImgDto.java
* 4. 작성일 : 2016. 2. 1. 오후 2:17:41
* 5. 작성자 : nick
* 6. 설명 : 호스텔 사진 정보 DTO
* </pre>
*/
public class ImgDto {
	private int hstImageNum;
	private int hstNum;
	private String imageName;
	
	public int getHstImageNum() {
		return hstImageNum;
	}
	public void setHstImageNum(int hstImageNum) {
		this.hstImageNum = hstImageNum;
	}
	public int getHstNum() {
		return hstNum;
	}
	public void setHstNum(int hstNum) {
		this.hstNum = hstNum;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
}
