package com.NeoRomax.HostelTonight.Rsv.Dto;

import java.sql.Timestamp;


public class RsvCheckDto {
	
	private Timestamp RSVDATE;
	private int RSVROOM;
	private int RSVABLE;
	private int RSVHOSTELNUM;
	private int RATE;
	public Timestamp getRSVDATE() {
		return RSVDATE;
	}
	public void setRSVDATE(Timestamp rSVDATE) {
		RSVDATE = rSVDATE;
	}
	public int getRSVROOM() {
		return RSVROOM;
	}
	public void setRSVROOM(int rSVROOM) {
		RSVROOM = rSVROOM;
	}
	public int getRSVABLE() {
		return RSVABLE;
	}
	public void setRSVABLE(int rSVABLE) {
		RSVABLE = rSVABLE;
	}
	public int getRSVHOSTELNUM() {
		return RSVHOSTELNUM;
	}
	public void setRSVHOSTELNUM(int rSVHOSTELNUM) {
		RSVHOSTELNUM = rSVHOSTELNUM;
	}
	public int getRATE() {
		return RATE;
	}
	public void setRATE(int rATE) {
		RATE = rATE;
	}
	
	
	

}
