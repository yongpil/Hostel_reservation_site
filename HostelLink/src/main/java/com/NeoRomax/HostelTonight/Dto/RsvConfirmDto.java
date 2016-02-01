package com.NeoRomax.HostelTonight.Dto;


/**
* <pre>
* 1. ������Ʈ�� : HostelTonight
* 2. ��Ű����(�Ǵ� ���丮 ���) : com.NeoRomax.HostelTonight.Dto
* 3. ���ϸ� : RsvConfirmDto.java
* 4. �ۼ��� : 2016. 2. 1. ���� 2:20:07
* 5. �ۼ��� : nick
* 6. ���� : ���� Ȯ�� ������ �����ֱ� ���� DTO
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
