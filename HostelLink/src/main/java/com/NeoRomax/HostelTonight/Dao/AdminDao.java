package com.NeoRomax.HostelTonight.Dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.NeoRomax.HostelTonight.Dto.LocationRsvHistoryDto;
import com.NeoRomax.HostelTonight.Dto.SchLocationDto;


/**
 * @author nick
 *
 */

public interface AdminDao {
	public ArrayList<SchLocationDto> SchLocationList();
	public LocationRsvHistoryDto getLocationRsvHistoryDto(String location);
}
