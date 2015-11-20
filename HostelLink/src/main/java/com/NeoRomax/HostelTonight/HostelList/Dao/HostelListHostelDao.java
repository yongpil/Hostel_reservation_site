package com.NeoRomax.HostelTonight.HostelList.Dao;

import java.util.ArrayList;

import com.NeoRomax.HostelTonight.HostelList.Dto.HostelListHostelDto;
import com.NeoRomax.HostelTonight.HostelList.Dto.HostelsListDto;

public interface HostelListHostelDao{
	public ArrayList<HostelsListDto> Hlist();
	public int getHstNumfromEmail(String HOSTELS_EMAIL);
	public void addHostel(String hOSTELS_NAME, String hOSTELS_NATION, String hOSTELS_CITY,
			String hOSTELS_ADDR, String hOSTELS_INFO, String hOSTELS_PHONE, String hOSTELS_EMAIL);
	public HostelListHostelDto getHDto(int hstNum);
}