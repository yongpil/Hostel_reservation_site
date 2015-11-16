package com.spring.HostelLink.dao;

import java.util.ArrayList;

import com.spring.HostelLink.dto.HostelImgDto;

public interface HImgDao {
	public ArrayList<HostelImgDto>getHImgList(int hstNum);
	public void addHImg(int hstNum, String imageName);
}
