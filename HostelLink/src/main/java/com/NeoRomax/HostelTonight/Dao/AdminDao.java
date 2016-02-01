package com.NeoRomax.HostelTonight.Dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.NeoRomax.HostelTonight.Dto.LocationRsvHistoryDto;
import com.NeoRomax.HostelTonight.Dto.SchLocationDto;



/**
* <pre>
* 1. ������Ʈ�� : HostelTonight
* 2. ��Ű����(�Ǵ� ���丮 ���) : com.NeoRomax.HostelTonight.Dao
* 3. ���ϸ� : AdminDao.java
* 4. �ۼ��� : 2016. 2. 1. ���� 3:03:10
* 5. �ۼ��� : nick
* 6. ���� : ������ ������ ������ �ҷ����� ���� DAO
* </pre>
*/

public interface AdminDao {
	public ArrayList<SchLocationDto> SchLocationList();
	public LocationRsvHistoryDto getLocationRsvHistoryDto(String location);
	public ArrayList<String> getLocation(); 
}
