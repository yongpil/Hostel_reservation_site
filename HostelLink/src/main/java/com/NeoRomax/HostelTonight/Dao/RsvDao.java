package com.NeoRomax.HostelTonight.Dao;

import java.sql.Date;
import java.util.List;

import com.NeoRomax.HostelTonight.Dto.RsvAddDto;
import com.NeoRomax.HostelTonight.Dto.RsvAvailableDto;
import com.NeoRomax.HostelTonight.Dto.RsvDaysAddDto;
import com.NeoRomax.HostelTonight.Dto.RsvRoomAddDto;


/**
 * <PRE>
 * 1. FileName  : RsvDao.java
 * 2. Package  : com.NeoRomax.HostelTonight.Rsv.Dao
 * 3. Comment  : 예약 기능들을 위한 DAO
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
	public void rsvAbleUpdate(int rsvHostelNum, int rsvRoom, Date date);
}
