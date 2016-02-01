package com.NeoRomax.HostelTonight.Dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.NeoRomax.HostelTonight.Dto.LocationRsvHistoryDto;
import com.NeoRomax.HostelTonight.Dto.SchLocationDto;



/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Dao
* 3. 파일명 : AdminDao.java
* 4. 작성일 : 2016. 2. 1. 오후 3:03:10
* 5. 작성자 : nick
* 6. 설명 : 관리자 페이지 정보를 불러오기 위한 DAO
* </pre>
*/

public interface AdminDao {
	public ArrayList<SchLocationDto> SchLocationList();
	public LocationRsvHistoryDto getLocationRsvHistoryDto(String location);
	public ArrayList<String> getLocation(); 
}
