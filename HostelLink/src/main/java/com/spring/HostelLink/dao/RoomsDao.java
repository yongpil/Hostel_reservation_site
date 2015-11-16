package com.spring.HostelLink.dao;

import java.util.List;

import com.spring.HostelLink.dto.RoomsDto;

public interface RoomsDao {
	public List<RoomsDto> RoomsList(int num);
}
