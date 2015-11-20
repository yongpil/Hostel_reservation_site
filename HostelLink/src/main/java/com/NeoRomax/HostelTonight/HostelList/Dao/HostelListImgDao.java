package com.NeoRomax.HostelTonight.HostelList.Dao;

import java.util.ArrayList;

import com.NeoRomax.HostelTonight.HostelList.Dto.HostelListImgDto;

/**
 * <PRE>
 * 1. FileName  : HostelListImgDao.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Dao
 * 3. Comment  : 
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 20. 오후 3:45:11
 * </PRE>
 */ 


public interface HostelListImgDao {
	public ArrayList<HostelListImgDto>getHImgList(int hstNum);
	public void addHImg(int hstNum, String imageName);
}
