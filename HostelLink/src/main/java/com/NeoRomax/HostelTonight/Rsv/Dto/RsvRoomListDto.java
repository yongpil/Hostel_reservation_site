/**
 * 0. Project  : hostelTonight 프로젝트
 *
 * 1. FileName : RscRoomListDto.java
 * 2. Package : com.NeoRomax.HostelTonight.Rsv.Dto
 * 3. Comment : 
 * 4. 작성자  : "Yong Pil Moon"
 * 5. 작성일  : 2015. 11. 27. 오후 2:52:04
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    "Yong Pil Moon" : 2015. 11. 27. :            : 신규 개발.
 */

package com.NeoRomax.HostelTonight.Rsv.Dto;

import java.util.ArrayList;

/**
 * <PRE>
 * 1. FileName  : RscRoomListDto.java
 * 2. Package  : com.NeoRomax.HostelTonight.Rsv.Dto
 * 3. Comment  : 
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 27. 오후 2:52:04
 * </PRE>
 */

public class RsvRoomListDto {
	private int ROOMS_NUM;
	private String ROOMS_NAME;
	private String ROOMS_INFO;
	private ArrayList<RsvCheckDto> RsvCheckDtos;
	
	
	
	public RsvRoomListDto() {

	}

	public RsvRoomListDto(int rOOMS_NUM, String rOOMS_NAME, String rOOMS_INFO, ArrayList<RsvCheckDto> rsvCheckList) {
		super();
		ROOMS_NUM = rOOMS_NUM;
		ROOMS_NAME = rOOMS_NAME;
		ROOMS_INFO = rOOMS_INFO;
		this.RsvCheckDtos = rsvCheckList;
	}
	
	public int getROOMS_NUM() {
		return ROOMS_NUM;
	}
	public void setROOMS_NUM(int rOOMS_NUM) {
		ROOMS_NUM = rOOMS_NUM;
	}
	public String getROOMS_NAME() {
		return ROOMS_NAME;
	}
	public void setROOMS_NAME(String rOOMS_NAME) {
		ROOMS_NAME = rOOMS_NAME;
	}
	public String getROOMS_INFO() {
		return ROOMS_INFO;
	}
	public void setROOMS_INFO(String rOOMS_INFO) {
		ROOMS_INFO = rOOMS_INFO;
	}
	public ArrayList<RsvCheckDto> getRsvCheckDtos() {
		return RsvCheckDtos;
	}

	public void setRsvCheckDtos(ArrayList<RsvCheckDto> rsvCheckDtos) {
		RsvCheckDtos = rsvCheckDtos;
	}

	/**
	 * <PRE>
	 * 1. MethodName : setRsvCheckList
	 * 2. ClassName  : RsvRoomListDto
	 * 3. Comment   : 
	 * 4. 작성자    : "Yong Pil Moon"
	 * 5. 작성일    : 2015. 11. 27. 오후 3:46:46
	 * </PRE>
	 *   @param rsvCheckDtos
	 */
	public void setRsvCheckList(ArrayList<RsvCheckDto> rsvCheckDtos) {
		// TODO Auto-generated method stub
		
	}
	
	
}
