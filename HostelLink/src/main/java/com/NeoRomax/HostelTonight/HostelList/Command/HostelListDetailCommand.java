package com.NeoRomax.HostelTonight.HostelList.Command;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.HostelList.Dao.HostelDao;
import com.NeoRomax.HostelTonight.HostelList.Dao.ImgDao;
import com.NeoRomax.HostelTonight.HostelList.Dao.RoomsDao;
import com.NeoRomax.HostelTonight.HostelList.Dto.RoomsDto;
import com.NeoRomax.HostelTonight.Rsv.Dao.RsvDao;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvAvailableDto;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvListDto;
import com.NeoRomax.HostelTonight.util.Constant;

/**
 * <PRE>
 * 1. FileName  : HostelListDetailCommand.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Command
 * 3. Comment  : room������ŭ�� RsvRoomListDto�� ��ü�� ����� rsvRoomListDtos�� List�� ��� hestel_detail.jsp�� ���� �Ѵ�.
 * 4. �ۼ���   : "Yong Pil Moon"
 * 5. �ۼ���   : 2015. 11. 20. ���� 3:44:57
 * </PRE>
 */ 


public class HostelListDetailCommand implements HCommand {
	SqlSession sqlSession = null;
	DateFormat outputFormattoer = new SimpleDateFormat("MM/dd/yyyy");
	public HostelListDetailCommand() {
		sqlSession = Constant.sqlSession;
	}
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HostelDao hDao = sqlSession.getMapper(HostelDao.class);
		ImgDao hImgDao = sqlSession.getMapper(ImgDao.class);
		RoomsDao roomsDao = sqlSession.getMapper(RoomsDao.class);
		RsvDao rsvDao = sqlSession.getMapper(RsvDao.class);
		
		ArrayList<RoomsDto> hostelListRoomDtos = (ArrayList<RoomsDto>)roomsDao.RoomsList(Integer.parseInt(request.getParameter("hstNum")));//�ش� hostel�� room������ ��� �ִ� List
		ArrayList<RsvAvailableDto> rsvAvailableDtos = (ArrayList<RsvAvailableDto>)rsvDao.rsvAvailList((Integer.parseInt(request.getParameter("hstNum"))),request.getParameter("dayFrom"),request.getParameter("dayTo"));
		ArrayList<RsvListDto> RsvListDtos = new ArrayList<RsvListDto>();//hostel_detail.jsp���� jstl�� ȭ�鿡 ���ϰ� �Ѹ������� ���� DTO

		model.addAttribute("hDto",hDao.getHDto(Integer.parseInt(request.getParameter("hstNum"))));
		model.addAttribute("hImgDtos",hImgDao.getHImgList(Integer.parseInt(request.getParameter("hstNum"))));
		model.addAttribute("roomsDtos",hostelListRoomDtos);
		model.addAttribute("RsvAbleDto",rsvAvailableDtos);
		model.addAttribute("dayFrom",request.getParameter("dayFrom"));
		model.addAttribute("dayTo",request.getParameter("dayTo"));
		
		
		for(int i=0;i<rsvAvailableDtos.size();i++)
		{
			System.out.println(rsvAvailableDtos.get(i).getRsvDate());
		}

		for(int i=0;i<hostelListRoomDtos.size();i++)
		{
			RsvListDto rsvListDto = new RsvListDto();
			RoomsDto hostelListRoomsDto = hostelListRoomDtos.get(i);
		
			rsvListDto.setRoomsNum(hostelListRoomsDto.getRoomsNum());
			rsvListDto.setRoomsName(hostelListRoomsDto.getRoomsName());
			rsvListDto.setRoomsInfo(hostelListRoomsDto.getRoomsInfo());
			ArrayList<RsvAvailableDto> rsvRoomCheckDtos = new ArrayList<RsvAvailableDto>();
			
			
			for(int j=0;j<rsvAvailableDtos.size();j++) //���ȣ�� ���� rsvAvailableDto�� �з��Ѵ�.
			{   
				if(hostelListRoomDtos.get(i).getRoomsNum()==rsvAvailableDtos.get(j).getRsvRoom())
				{
					rsvRoomCheckDtos.add(rsvAvailableDtos.get(j));		
				}
			}
			rsvListDto.settRsvAvailableDtos(rsvRoomCheckDtos);
			RsvListDtos.add(rsvListDto);
		}
		
		model.addAttribute("rsvListDtos",RsvListDtos);
	}
		
	}

