package com.NeoRomax.HostelTonight.Dto;

/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Dto
* 3. 파일명 : SchLocationDto.java
* 4. 작성일 : 2016. 2. 1. 오후 3:02:17
* 5. 작성자 : nick
* 6. 설명 : 지역별 성수기 기능을 위한 DTO
* </pre>
*/
public class SchLocationDto {
	private String location;
	private int searchCnt;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getSearchCnt() {
		return searchCnt;
	}
	public void setSearchCnt(int searchCnt) {
		this.searchCnt = searchCnt;
	}
	
}
	
	
	

