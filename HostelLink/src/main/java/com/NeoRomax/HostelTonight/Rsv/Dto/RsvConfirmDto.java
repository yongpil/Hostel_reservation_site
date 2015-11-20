package com.NeoRomax.HostelTonight.Rsv.Dto;

public class RsvConfirmDto {
	private int RSVNUM;
	private int HOSTELNUM;
	private int ROOMNUM;
	private String USERID;
	private String RESERVATIONDAYS;
	private int  TOTALRATE;
	
	
	public RsvConfirmDto( int hOSTELNUM, int rOOMNUM, String uSERID, String rESERVATIONDAYS, int tOTALRATE) {
		super();
		HOSTELNUM = hOSTELNUM;
		ROOMNUM = rOOMNUM;
		USERID = uSERID;
		RESERVATIONDAYS = rESERVATIONDAYS;
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
	public String getRESERVATIONDAYS() {
		return RESERVATIONDAYS;
	}
	public void setRESERVATIONDAYS(String rESERVATIONDAYS) {
		RESERVATIONDAYS = rESERVATIONDAYS;
	}
	public int getTOTALRATE() {
		return TOTALRATE;
	}
	public void setTOTALRATE(int tOTALRATE) {
		TOTALRATE = tOTALRATE;
	}
	
	
	
}
