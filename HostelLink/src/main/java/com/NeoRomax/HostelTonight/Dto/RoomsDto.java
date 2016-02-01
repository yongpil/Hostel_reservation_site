package com.NeoRomax.HostelTonight.Dto;


/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Dto
* 3. 파일명 : RoomsDto.java
* 4. 작성일 : 2016. 2. 1. 오후 2:19:14
* 5. 작성자 : nick
* 6. 설명 : 객체 정보를 위한 DTO
* </pre>
*/
public class RoomsDto {
private int roomsNum;
private int hostelsNum;
private String roomsName;
private String roomsInfo;
private String roomsImage;

public int getRoomsNum() {
	return roomsNum;
}
public void setRoomsNum(int roomsNum) {
	this.roomsNum = roomsNum;
}
public int getHostelsNum() {
	return hostelsNum;
}
public void setHostelsNum(int hostelsNum) {
	this.hostelsNum = hostelsNum;
}
public String getRoomsName() {
	return roomsName;
}
public void setRoomsName(String roomsName) {
	this.roomsName = roomsName;
}
public String getRoomsInfo() {
	return roomsInfo;
}
public void setRoomsInfo(String roomsInfo) {
	this.roomsInfo = roomsInfo;
}
public String getRoomsImage() {
	return roomsImage;
}
public void setRoomsImage(String roomsImage) {
	this.roomsImage = roomsImage;
}


}
