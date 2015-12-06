package com.NeoRomax.HostelTonight.Rsv.Dao;

import java.util.List;

import com.NeoRomax.HostelTonight.Rsv.Dto.RsvAddDto;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvAvailableDto;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvDaysAddDto;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvRoomAddDto;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvSessionDto;


/**
 * <PRE>
 * 1. FileName  : RsvDao.java
 * 2. Package  : com.NeoRomax.HostelTonight.Rsv.Dao
 * 3. Comment  : 
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 20. 오후 3:45:39
 * </PRE>
 */ 


public interface RsvDao {
	public List<RsvAvailableDto> rsvAvailList(int num, String dayfrom, String dayto);
	public int rsvAdd(RsvAddDto rsvAddDto);
	public RsvAddDto getRsvList(int num);
	public int rsvRoomsAdd(RsvRoomAddDto rsvRoomAddDto);
	public void rsvDaysAdd(RsvDaysAddDto rsvDaysAddDto);
	
}
