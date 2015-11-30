package com.NeoRomax.HostelTonight.HostelList.Command;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.HostelList.Dao.HostelListHostelDao;
import com.NeoRomax.HostelTonight.HostelList.Dao.HostelListImgDao;
import com.NeoRomax.HostelTonight.HostelList.Dao.HostelListRoomsDao;
import com.NeoRomax.HostelTonight.HostelList.Dto.HostelListRoomsDto;
import com.NeoRomax.HostelTonight.Rsv.Dao.RsvDao;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvAvailableDto;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvRoomListDto;
import com.NeoRomax.HostelTonight.util.Constant;

/**
 * <PRE>
 * 1. FileName  : HostelListDetailCommand.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Command
 * 3. Comment  : 
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 20. 오후 3:44:57
 * </PRE>
 */ 


public class HostelListDetailCommand implements HostelListCommand {
	SqlSession sqlSession = null;
	DateFormat outputFormattoer = new SimpleDateFormat("MM/dd/yyyy");
	public HostelListDetailCommand() {
		sqlSession = Constant.sqlSession;
	}
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HostelListHostelDao hDao = sqlSession.getMapper(HostelListHostelDao.class);
		HostelListImgDao hImgDao = sqlSession.getMapper(HostelListImgDao.class);
		HostelListRoomsDao roomsDao = sqlSession.getMapper(HostelListRoomsDao.class);
		RsvDao rsvDao = sqlSession.getMapper(RsvDao.class);
		
		model.addAttribute("hDto",hDao.getHDto(Integer.parseInt(request.getParameter("num"))));
		model.addAttribute("hImgDtos",hImgDao.getHImgList(Integer.parseInt(request.getParameter("num"))));
		model.addAttribute("roomsDtos",roomsDao.RoomsList(Integer.parseInt(request.getParameter("num"))));
		model.addAttribute("RsvAbleDto",rsvDao.rsvList((Integer.parseInt(request.getParameter("num"))),"20150915","20150920"));
		ArrayList<HostelListRoomsDto> hostelListRoomDtos = (ArrayList<HostelListRoomsDto>)roomsDao.RoomsList(Integer.parseInt(request.getParameter("num")));
		ArrayList<RsvAvailableDto> rsvAvailableDtos = (ArrayList<RsvAvailableDto>)rsvDao.rsvList((Integer.parseInt(request.getParameter("num"))),"20150914","20150920");
		ArrayList<RsvRoomListDto> rsvRoomListDtos = new ArrayList<RsvRoomListDto>();
		

		for(int i=0;i<hostelListRoomDtos.size();i++)
		{
			RsvRoomListDto rsvRoomListDto = new RsvRoomListDto();
			HostelListRoomsDto hostelListRoomsDto = hostelListRoomDtos.get(i);
		
			rsvRoomListDto.setRoomsNum(hostelListRoomsDto.getROOMS_NUM());
			rsvRoomListDto.setRoomsName(hostelListRoomsDto.getROOMS_NAME());
			rsvRoomListDto.setRoomsInfo(hostelListRoomsDto.getROOMS_INFO());
			ArrayList<RsvAvailableDto> rsvRoomCheckDtos = new ArrayList<RsvAvailableDto>();
			
			for(int j=0;j<rsvAvailableDtos.size();j++)
			{   
				if(rsvAvailableDtos.get(j).getRsvRoom()==i)
				{
					rsvRoomCheckDtos.add(rsvAvailableDtos.get(j));		
				}
			}
			rsvRoomListDto.settRsvAvailableDtos(rsvRoomCheckDtos);
			rsvRoomListDtos.add(rsvRoomListDto);
		}
		
		
		model.addAttribute("rsvRoomListDtos",rsvRoomListDtos);
	}
		
	}

