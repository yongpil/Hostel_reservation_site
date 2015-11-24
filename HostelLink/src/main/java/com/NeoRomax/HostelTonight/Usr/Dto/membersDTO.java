package com.NeoRomax.HostelTonight.Usr.Dto;

/**
 * Members Data Transfer Object
 * @version 1.0
 * @author Yang Jin Seung 
 */

import java.util.Date;

public class membersDTO {

	private int usrNum;
	private String usrId;
	private String usrPsw;
	private String usrConfirmPsw;
	private String usrFirstName;
	private String usrLastName;
	private Date usrBirth ;
	private String usrEmail;
	
	
	public membersDTO(int usrNum, String usrId, String usrPsw, String usrConfirmPsw, String usrFirstName,
			String usrLastName, Date usrBirth, String usrEmail) {
		super();
		this.usrNum = usrNum;
		this.usrId = usrId;
		this.usrPsw = usrPsw;
		this.usrConfirmPsw = usrConfirmPsw;
		this.usrFirstName = usrFirstName;
		this.usrLastName = usrLastName;
		this.usrBirth = usrBirth;
		this.usrEmail = usrEmail;
	}
	
	public int getUsrNum() {
		return usrNum;
	}
	public void setUsrNum(int usrNum) {
		this.usrNum = usrNum;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getUsrPsw() {
		return usrPsw;
	}
	public void setUsrPsw(String usrPsw) {
		this.usrPsw = usrPsw;
	}
	public String getUsrConfirmPsw() {
		return usrConfirmPsw;
	}
	public void setUsrConfirmPsw(String usrConfirmPsw) {
		this.usrConfirmPsw = usrConfirmPsw;
	}
	public String getUsrFirstName() {
		return usrFirstName;
	}
	public void setUsrFirstName(String usrFirstName) {
		this.usrFirstName = usrFirstName;
	}
	public String getUsrLastName() {
		return usrLastName;
	}
	public void setUsrLastName(String usrLastName) {
		this.usrLastName = usrLastName;
	}
	public Date getUsrBirth() {
		return usrBirth;
	}
	public void setUsrBirth(Date usrBirth) {
		this.usrBirth = usrBirth;
	}
	public String getUsrEmail() {
		return usrEmail;
	}
	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}
	
	
	
}
