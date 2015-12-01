package com.NeoRomax.HostelTonight.Rsv.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.HostelList.Command.HostelListCommand;
import com.NeoRomax.HostelTonight.HostelList.Dao.HostelDao;
import com.NeoRomax.HostelTonight.HostelList.Dao.RoomsDao;
import com.NeoRomax.HostelTonight.HostelList.Dto.HostelDto;
import com.NeoRomax.HostelTonight.HostelList.Dto.RoomsDto;
import com.NeoRomax.HostelTonight.Rsv.Dao.RsvDao;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvAvailableDto;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvConfirmDto;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvRoomListDto;
import com.NeoRomax.HostelTonight.util.Constant;

/**
 * <PRE>
 * 1. FileName  : RsvViewCommand.java
 * 2. Package  : com.NeoRomax.HostelTonight.Rsv.Command
 * 3. Comment  : 
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 20. 오후 3:45:34
 * </PRE>
 */ 


public class RsvViewCommand implements HostelListCommand {
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
		
		System.out.println(request.getParameter("hostelNum"));
		
		List<RoomsDto> roomList = new ArrayList<RoomsDto>();
		roomList = roomsDao.RoomsList(Integer.parseInt(request.getParameter("hostelNum")));
		System.out.println(request.getParameter("hostelNum"));
		List<RsvAvailableDto> rsvAbleDto = rsvDao.rsvList((Integer.parseInt(request.getParameter("hostelNum"))),"20150915","20150920");
		
	 	ArrayList<ArrayList<String>> rsvDatesList = new ArrayList<ArrayList<String>>();
	 	ArrayList<ArrayList<String>> rsvRatesList = new ArrayList<ArrayList<String>>();
	 	
	 	
	 	
	 		
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
				}
			}
			
			if(rsvDates!=null)
				rsvDatesList.add(rsvDates);
			if(rsvRates!=null)
				rsvRatesList.add(rsvRates);
		}
		
	 	model.addAttribute("rsvDatesList", rsvDatesList);
	 	model.addAttribute("rsvRatesList", rsvRatesList);
	 	model.addAttribute("hostelDto", hDao.getHDto(Integer.parseInt(request.getParameter("hostelNum"))));
	 	model.addAttribute("roomList", roomList);
	 	
	/* 	for(int i=0;i<60;i++)//앞에서 체크된 객실들을 가지고 객실별로 체크된 요금은 rsvRate배열에 날짜는 rsvDate에 넣는다.
	 	{
	 		checkBox[i]="checkBox"+i;
	 		
	 		if(i>=0 && i<12 && request.getParameter(checkBox[i])!=null)
	 		{
	 			String[] tempRsv = request.getParameter(checkBox[i]).split(",");//,로 구분 되어 있는 rsvRate와 rsvDate를 분리 한다.
	 			rsvRate[0] = rsvRate[0] + Integer.parseInt(tempRsv[0]); //tempRsv[0]은 해당 방의 가격이고 tempRsv[1]은 해당 방의 예약 날짜 이다.
	 			rsvDate[0] = rsvDate[0] + tempRsv[1];
	 		}
	 		else if(i>=12 && i<24 && request.getParameter(checkBox[i])!=null)
	 		{
	 			String[] tempRsv = request.getParameter(checkBox[i]).split(",");
	 			rsvRate[1] = rsvRate[1] + Integer.parseInt(tempRsv[0]); 
	 			rsvDate[1] = rsvDate[1] + tempRsv[1] + ",";
	 		}
	 		else if(i>=24 && i<36 && request.getParameter(checkBox[i])!=null)
	 		{
	 			String[] tempRsv = request.getParameter(checkBox[i]).split(",");
	 			rsvRate[2] = rsvRate[2] + Integer.parseInt(tempRsv[0]); 
	 			rsvDate[2] = rsvDate[2] + tempRsv[1];

	 		}
	 		else if(i>=36 && i<48 && request.getParameter(checkBox[i])!=null)
	 		{
	 			String[] tempRsv = request.getParameter(checkBox[i]).split(",");
	 			rsvRate[3] = rsvRate[3] + Integer.parseInt(tempRsv[0]); 
	 			rsvDate[3] = rsvDate[3] + tempRsv[1];
	 		}
	 		else if(i>=48 && i<60 && request.getParameter(checkBox[i])!=null)
	 		{
	 			String[] tempRsv = request.getParameter(checkBox[i]).split(",");
	 			rsvRate[4] = rsvRate[4] + Integer.parseInt(tempRsv[0]); 
	 			rsvDate[4] = rsvDate[4] + tempRsv[1];
	 		}
	 	}*/
	 	
/*	 	for(int i=0;i<5;i++)
	 	{
	 		if(!rsvDate[i].equals(""))//rsvDate가 널이 아니면
	 		{
	 			rsvDate[i]= rsvDate[i].substring(0, rsvDate[i].length()-1);//rsvDate의 마지막에 들어있는 ,를 제거 하고
	 			RsvConfirmDto rsvbean = new RsvConfirmDto(Integer.parseInt(request.getParameter("hostelNum")),i,request.getParameter("userId"),rsvRate[i]); //예약 객체를 만들어 저장한다.
	 			rsvConfirmList.add(rsvbean);
	 		}		
	 		
	 	}
	 	
	 	model.addAttribute("rsvConfirmList", rsvConfirmList);
	 	model.addAttribute("hostelbean", hostelDto);
	 	model.addAttribute("roomList", roomList);*/

	}

}
