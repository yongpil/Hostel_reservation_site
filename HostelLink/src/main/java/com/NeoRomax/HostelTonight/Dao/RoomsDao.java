package com.NeoRomax.HostelTonight.Dao;

import java.util.List;

import com.NeoRomax.HostelTonight.Dto.RoomsDto;

/**
 * <PRE>
 * 1. FileName  : HostelListRoomsDao.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Dao
 * 3. Comment  : 객실관련 정보를 불러오기 위한 DAO
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 20. 오후 3:45:14
 * </PRE>
 */ 


public interface RoomsDao {
	public List<RoomsDto> RoomsList(int num);
}
