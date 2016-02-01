package com.NeoRomax.HostelTonight.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.NeoRomax.HostelTonight.Dto.HostelDto;
import com.NeoRomax.HostelTonight.Dto.HostelsListDto;
import com.NeoRomax.HostelTonight.Dto.ImgDto;

/**
 * <PRE>
 * 1. FileName  : HostelListHostelDao.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Dao
 * 3. Comment  : 호스텔 기능들에 필요한 데이터를 불러오기 위한 DAO
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 20. 오후 3:45:08
 * </PRE>
 */ 


public interface HostelDao{
	public ArrayList<HostelsListDto> Hlist(String lctSearch);
	public HostelDto getHDto(int hstNum);
	public int addHostel(HostelDto hostelDto);
	public ArrayList<ImgDto>getHImgList(int hstNum);
	public void addHImg(int hstNum, String imageName);
}