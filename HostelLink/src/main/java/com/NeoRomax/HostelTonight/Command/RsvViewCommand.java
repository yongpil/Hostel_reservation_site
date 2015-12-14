package com.NeoRomax.HostelTonight.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.Dao.HostelDao;
import com.NeoRomax.HostelTonight.Dao.RoomsDao;
import com.NeoRomax.HostelTonight.Dao.RsvDao;
import com.NeoRomax.HostelTonight.Dto.RoomsDto;
import com.NeoRomax.HostelTonight.Dto.RsvAvailableDto;
import com.NeoRomax.HostelTonight.Dto.RsvSessionDto;

import util.Constant;

/**
 * <PRE>
 * 1. FileName  : RsvViewCommand.java
 * 2. Package  : com.NeoRomax.HostelTonight.Rsv.Command
 * 3. Comment  : 
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 20. 오후 3:45:34
 * </PRE>
 */ 


public class RsvViewCommand implements HCommand {
	SqlSession sqlSession = null;
	
	public RsvViewCommand() {
		sqlSession = Constant.sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HostelDao hDao = sqlSession.getMapper(HostelDao.class);
		RoomsDao roomsDao = sqlSession.getMapper(RoomsDao.class);
		RsvDao rsvDao = sqlSession.getMapper(RsvDao.class);
		

		
		List<RoomsDto> roomList = new ArrayList<RoomsDto>();
		roomList = roomsDao.RoomsList(Integer.parseInt(request.getParameter("hostelNum")));
		List<RsvAvailableDto> rsvAbleDto = rsvDao.rsvAvailList((Integer.parseInt(request.getParameter("hostelNum"))),request.getParameter("dayFrom"),request.getParameter("dayTo"));
		
	 	ArrayList<ArrayList<String>> rsvDatesList = new ArrayList<ArrayList<String>>();
	 	ArrayList<ArrayList<String>> rsvRatesList = new ArrayList<ArrayList<String>>();
	 	
	 	int totalRate=0;
	 	int eachRoomRate[] = new int[roomList.size()];
	 	
	 	for(int i=0;i<eachRoomRate.length;i++) //initiation
	 	{
	 		eachRoomRate[i]=0;
	 	}
	 	
	 		
		for(int i=0;i<roomList.size();i++)
		{
			ArrayList<String> rsvDates =  new ArrayList<String>();
			ArrayList<String> rsvRates = new ArrayList<String>();
			
			for(int j=0;j<rsvAbleDto.size();j++)
			{   
				if(request.getParameter("check"+i+"-"+j) != null)
				{
					String[] tempRsv = request.getParameter("check"+i+"-"+j).split(",");//,로 구분 되어 있는 rsvRate와 rsvDate를 분리 한다.
					rsvDates.add(tempRsv[0]);
					rsvRates.add(tempRsv[1]);
					eachRoomRate[i] =  eachRoomRate[i] + Integer.valueOf(tempRsv[1]);
				}
			}
			
			if(rsvDates!=null)
				rsvDatesList.add(rsvDates);
			if(rsvRates!=null)
				rsvRatesList.add(rsvRates);
		}
		
		for(int i=0;i<eachRoomRate.length;i++) //total calculation
	 	{
	 		totalRate = totalRate + eachRoomRate[i];
	 	}
	 	
		RsvSessionDto sessionDto = new RsvSessionDto(rsvDatesList,rsvRatesList,
				hDao.getHDto(Integer.parseInt(request.getParameter("hostelNum"))),roomList,totalRate,request.getParameter("userId"));
	 	model.addAttribute("sessionDto",sessionDto);
	 	
	 	
	}

}
