package com.spring.HostelLink.dao;

import java.util.ArrayList;

import com.spring.HostelLink.dto.HostelDto;
import com.spring.HostelLink.dto.HostelsListDto;

public interface HDao{
	public ArrayList<HostelsListDto> Hlist();
	public int getHstNumfromEmail(String HOSTELS_EMAIL);
	public void addHostel(String hOSTELS_NAME, String hOSTELS_NATION, String hOSTELS_CITY,
			String hOSTELS_ADDR, String hOSTELS_INFO, String hOSTELS_PHONE, String hOSTELS_EMAIL);
	public HostelDto getHDto(int hstNum);
}