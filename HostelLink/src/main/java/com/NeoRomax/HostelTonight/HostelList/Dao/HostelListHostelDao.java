package com.NeoRomax.HostelTonight.HostelList.Dao;

import java.util.ArrayList;

import com.NeoRomax.HostelTonight.HostelList.Dto.HostelListHostelDto;
import com.NeoRomax.HostelTonight.HostelList.Dto.HostelsListDto;

/**
 * <PRE>
 * 1. FileName  : HostelListHostelDao.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Dao
 * 3. Comment  : 
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 20. 오후 3:45:08
 * </PRE>
 */ 


public interface HostelListHostelDao{
	public ArrayList<HostelsListDto> Hlist();
	public int getHstNumfromEmail(String HOSTELS_EMAIL);
	public void addHostel(String hOSTELS_NAME, String hOSTELS_NATION, String hOSTELS_CITY,
			String hOSTELS_ADDR, String hOSTELS_INFO, String hOSTELS_PHONE, String hOSTELS_EMAIL);
	public HostelListHostelDto getHDto(int hstNum);
}