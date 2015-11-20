package com.NeoRomax.HostelTonight.HostelList.Command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.HostelList.Dao.HostelListHostelDao;
import com.NeoRomax.HostelTonight.HostelList.Dao.HostelListImgDao;
import com.NeoRomax.HostelTonight.HostelList.Dao.HostelListRoomsDao;
import com.NeoRomax.HostelTonight.Rsv.Dao.RsvDao;
import com.NeoRomax.HostelTonight.util.Constant;

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
	}

}
