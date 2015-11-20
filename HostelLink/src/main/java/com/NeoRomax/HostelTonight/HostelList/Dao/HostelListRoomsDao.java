package com.NeoRomax.HostelTonight.HostelList.Dao;

import java.util.List;

import com.NeoRomax.HostelTonight.HostelList.Dto.HostelListRoomsDto;

public interface HostelListRoomsDao {
	public List<HostelListRoomsDto> RoomsList(int num);
}
