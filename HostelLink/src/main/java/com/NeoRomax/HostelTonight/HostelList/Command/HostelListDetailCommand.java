package com.NeoRomax.HostelTonight.HostelList.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.HostelList.Dao.HostelListHostelDao;
import com.NeoRomax.HostelTonight.HostelList.Dao.HostelListImgDao;
import com.NeoRomax.HostelTonight.HostelList.Dao.HostelListRoomsDao;
import com.NeoRomax.HostelTonight.HostelList.Dto.HostelListRoomsDto;
import com.NeoRomax.HostelTonight.Rsv.Dao.RsvDao;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvCheckDto;
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
		model.addAttribute("RsvCheckDto",rsvDao.rsvList((Integer.parseInt(request.getParameter("num"))),"20150915","20150920"));
		ArrayList<HostelListRoomsDto> hostelListRoomDtos = (ArrayList<HostelListRoomsDto>)roomsDao.RoomsList(Integer.parseInt(request.getParameter("num")));
		ArrayList<RsvCheckDto> rsvCheckDtos = (ArrayList<RsvCheckDto>)rsvDao.rsvList((Integer.parseInt(request.getParameter("num"))),"20150915","20150920");
		
		RsvRoomListDto rsvRoomListDto = new RsvRoomListDto();
		
		for(int i=0;i<hostelListRoomDtos.size();i++)
		{
			
			HostelListRoomsDto hostelListRoomsDto = hostelListRoomDtos.get(i);
		
			rsvRoomListDto.setROOMS_NUM(hostelListRoomsDto.getROOMS_NUM());
			rsvRoomListDto.setROOMS_NAME(hostelListRoomsDto.getROOMS_NAME());
			rsvRoomListDto.setROOMS_INFO(hostelListRoomsDto.getROOMS_INFO());
			ArrayList<RsvCheckDto> RsvCheckDtos = new ArrayList<RsvCheckDto>();
			
			for(int j=0;j<rsvCheckDtos.size();j++)
			{
				if(rsvCheckDtos.get(j).getRSVROOM()==i);
				RsvCheckDtos.add(rsvCheckDtos.get(j));
			}
			rsvRoomListDto.setRsvCheckList(RsvCheckDtos);
		}
		System.out.println(rsvRoomListDto.getROOMS_NUM());
		model.addAttribute("rsvRoomListDto",rsvRoomListDto);
	}
		
	}

