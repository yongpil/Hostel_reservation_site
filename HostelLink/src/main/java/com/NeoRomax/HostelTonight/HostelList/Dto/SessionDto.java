package com.NeoRomax.HostelTonight.HostelList.Dto;

import java.util.ArrayList;
import java.util.List;

public class SessionDto {

	private ArrayList<ArrayList<String>> rsvDatesList;
	private ArrayList<ArrayList<String>> rsvRatesList;
	private HostelDto hostelDto;
	private List<RoomsDto> roomList;
	private int totalRate;
	
	
	
	public SessionDto(ArrayList<ArrayList<String>> rsvDatesList, ArrayList<ArrayList<String>> rsvRatesList,
			HostelDto hostelDto, List<RoomsDto> roomList, int totalRate) {
		super();
		this.rsvDatesList = rsvDatesList;
		this.rsvRatesList = rsvRatesList;
		this.hostelDto = hostelDto;
		this.roomList = roomList;
		this.totalRate = totalRate;
	}
	
	public ArrayList<ArrayList<String>> getRsvDatesList() {
		return rsvDatesList;
	}
	public void setRsvDatesList(ArrayList<ArrayList<String>> rsvDatesList) {
		this.rsvDatesList = rsvDatesList;
	}
	public ArrayList<ArrayList<String>> getRsvRatesList() {
		return rsvRatesList;
	}
	public void setRsvRatesList(ArrayList<ArrayList<String>> rsvRatesList) {
		this.rsvRatesList = rsvRatesList;
	}
	public HostelDto getHostelDto() {
		return hostelDto;
	}
	public void setHostelDto(HostelDto hostelDto) {
		this.hostelDto = hostelDto;
	}
	public List<RoomsDto> getRoomList() {
		return roomList;
	}
	public void setRoomList(List<RoomsDto> roomList) {
		this.roomList = roomList;
	}
	public int getTotalRate() {
		return totalRate;
	}
	public void setTotalRate(int totalRate) {
		this.totalRate = totalRate;
	}
	
	
}