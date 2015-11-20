package com.NeoRomax.HostelTonight.Rsv.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.HostelList.Command.HostelListCommand;
import com.NeoRomax.HostelTonight.HostelList.Dao.HostelListHostelDao;
import com.NeoRomax.HostelTonight.HostelList.Dao.HostelListRoomsDao;
import com.NeoRomax.HostelTonight.HostelList.Dto.HostelListHostelDto;
import com.NeoRomax.HostelTonight.HostelList.Dto.HostelListRoomsDto;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvConfirmDto;
import com.NeoRomax.HostelTonight.util.Constant;

public class RsvViewCommand implements HostelListCommand {
	SqlSession sqlSession = null;
public RsvViewCommand() {
	sqlSession = Constant.sqlSession;
}
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HostelListHostelDao hDao = sqlSession.getMapper(HostelListHostelDao.class);
		HostelListRoomsDao roomsDao = sqlSession.getMapper(HostelListRoomsDao.class);
		List<HostelListRoomsDto> roomList = new ArrayList<HostelListRoomsDto>();
		
		HostelListHostelDto hostelDto;
		hostelDto = hDao.getHDto(Integer.parseInt(request.getParameter("hostelNum")));
		roomList = roomsDao.RoomsList(Integer.parseInt(request.getParameter("hostelNum")));
		
		
	 	ArrayList rsvConfirmList = new ArrayList();
	 	String checkBox[] = new String[60];
	 	String rsvDate[] =  new String[5];
	 	int rsvRate[] = new int[5];
	 	
	 	for(int i=0;i<5;i++)
	 	{
	 		rsvDate[i]="";
	 		rsvRate[i]=0;
	 	}
	 		
	 	for(int i=0;i<60;i++)
	 	{
	 		checkBox[i]="checkBox"+i;
	 		
	 		if(i>=0 && i<12 && request.getParameter(checkBox[i])!=null)
	 		{
	 			String[] tempRsv = request.getParameter(checkBox[i]).split(",");
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
	 	}
	 	
	 	for(int i=0;i<5;i++)
	 	{
	 		if(!rsvDate[i].equals(""))
	 		{
	 			rsvDate[i]= rsvDate[i].substring(0, rsvDate[i].length()-1);
	 			RsvConfirmDto rsvbean = new RsvConfirmDto(Integer.parseInt(request.getParameter("hostelNum")),i,request.getParameter("userId"),rsvDate[i],rsvRate[i]);
	 			rsvConfirmList.add(rsvbean);
	 		}		
	 		
	 	}
	 	
	 	model.addAttribute("rsvConfirmList", rsvConfirmList);
	 	model.addAttribute("hostelbean", hostelDto);
	 	model.addAttribute("roomList", roomList);

	}

}
