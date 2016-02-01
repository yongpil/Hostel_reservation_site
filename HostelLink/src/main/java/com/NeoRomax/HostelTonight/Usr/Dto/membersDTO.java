package com.NeoRomax.HostelTonight.Usr.Dto;

/**
 * Members Data Transfer Object
 * @version 1.0
 * @author Yang Jin Seung 
 */

import java.util.Date;

/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Usr.Dto
* 3. 파일명 : membersDTO.java
* 4. 작성일 : 2016. 2. 1. 오후 3:10:31
* 5. 작성자 : Yang Jin Seung 
* 6. 설명 : 사용자 관리 정보를 위한 DTO
* </pre>
*/
public class membersDTO {

	private int usrNum;
	private String usrId;
	private String usrPsw;
	private String usrConfirmPsw;
	private String usrFirstName;
	private String usrLastName;
	private Date usrBirth ;
	private String usrEmail;
	
	
	public membersDTO(String usrId, String usrPsw, String usrConfirmPsw, String usrFirstName,
			String usrLastName) {
		super();
		this.usrId = usrId;
		this.usrPsw = usrPsw;
		this.usrConfirmPsw = usrConfirmPsw;
		this.usrFirstName = usrFirstName;
		this.usrLastName = usrLastName;
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
