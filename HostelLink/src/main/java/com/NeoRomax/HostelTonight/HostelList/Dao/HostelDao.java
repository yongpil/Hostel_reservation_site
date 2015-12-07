package com.NeoRomax.HostelTonight.HostelList.Dao;

import java.util.ArrayList;

import com.NeoRomax.HostelTonight.HostelList.Dto.HostelDto;
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


public interface HostelDao{
	public ArrayList<HostelsListDto> Hlist(String lctSearch);
	public int getHstNumfromEmail(String hostelsEmail);
	public void addHostel(String hostelsName, String hostelsNation, String hostelsCity,
			String hostelsAddr, String hostelsInfo, String hostelsPhone, String hostelsEmail);
	public HostelDto getHDto(int hstNum);
}