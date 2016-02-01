package com.NeoRomax.HostelTonight.Dto;


/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Dto
* 3. 파일명 : RsvConfirmDto.java
* 4. 작성일 : 2016. 2. 1. 오후 2:20:07
* 5. 작성자 : nick
* 6. 설명 : 예약 확정 정보를 보여주기 위한 DTO
* </pre>
*/
public class RsvConfirmDto {
	private int RSVNUM;
	private int HOSTELNUM;
	private int ROOMNUM;
	private String USERID;
	private int  TOTALRATE;
	
	
	public RsvConfirmDto( int hOSTELNUM, int rOOMNUM, String uSERID, int tOTALRATE) {
		super();
		HOSTELNUM = hOSTELNUM;
		ROOMNUM = rOOMNUM;
		USERID = uSERID;
		TOTALRATE = tOTALRATE;
	}
	
	public RsvConfirmDto() {
		// TODO Auto-generated constructor stub
	}

	public int getRSVNUM() {
		return RSVNUM;
	}
	public void setRSVNUM(int rSVNUM) {
		RSVNUM = rSVNUM;
	}
	public int getHOSTELNUM() {
		return HOSTELNUM;
	}
	public void setHOSTELNUM(int hOSTELNUM) {
		HOSTELNUM = hOSTELNUM;
	}
	public int getROOMNUM() {
		return ROOMNUM;
	}
	public void setROOMNUM(int rOOMNUM) {
		ROOMNUM = rOOMNUM;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public int getTOTALRATE() {
		return TOTALRATE;
	}
	public void setTOTALRATE(int tOTALRATE) {
		TOTALRATE = tOTALRATE;
	}
	
	
	
}
