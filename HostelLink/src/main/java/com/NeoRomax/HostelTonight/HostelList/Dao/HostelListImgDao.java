package com.NeoRomax.HostelTonight.HostelList.Dao;

import java.util.ArrayList;

import com.NeoRomax.HostelTonight.HostelList.Dto.HostelListImgDto;

public interface HostelListImgDao {
	public ArrayList<HostelListImgDto>getHImgList(int hstNum);
	public void addHImg(int hstNum, String imageName);
}
