package com.NeoRomax.HostelTonight.HostelList.Dao;

import java.util.List;

import com.NeoRomax.HostelTonight.HostelList.Dto.HostelListRoomsDto;

/**
 * <PRE>
 * 1. FileName  : HostelListRoomsDao.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Dao
 * 3. Comment  : 
 * 4. �ۼ���   : "Yong Pil Moon"
 * 5. �ۼ���   : 2015. 11. 20. ���� 3:45:14
 * </PRE>
 */ 


public interface HostelListRoomsDao {
	public List<HostelListRoomsDto> RoomsList(int num);
}
