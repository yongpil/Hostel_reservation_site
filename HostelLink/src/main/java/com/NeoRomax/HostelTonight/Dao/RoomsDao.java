package com.NeoRomax.HostelTonight.Dao;

import java.util.List;

import com.NeoRomax.HostelTonight.Dto.RoomsDto;

/**
 * <PRE>
 * 1. FileName  : HostelListRoomsDao.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Dao
 * 3. Comment  : 
 * 4. �ۼ���   : "Yong Pil Moon"
 * 5. �ۼ���   : 2015. 11. 20. ���� 3:45:14
 * </PRE>
 */ 


public interface RoomsDao {
	public List<RoomsDto> RoomsList(int num);
}
