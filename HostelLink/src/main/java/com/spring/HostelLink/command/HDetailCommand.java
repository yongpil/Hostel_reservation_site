package com.spring.HostelLink.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.spring.HostelLink.dao.HDao;
import com.spring.HostelLink.dao.HImgDao;
import com.spring.HostelLink.dao.RoomsDao;
import com.spring.HostelLink.rsv.dao.RsvDao;
import com.spring.HostelLink.util.Constant;

public class HDetailCommand implements HCommand {
	SqlSession sqlSession = null;
	
	public HDetailCommand() {
		sqlSession = Constant.sqlSession;
	}
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HDao hDao = sqlSession.getMapper(HDao.class);
		HImgDao hImgDao = sqlSession.getMapper(HImgDao.class);
		RoomsDao roomsDao = sqlSession.getMapper(RoomsDao.class);
		RsvDao rsvDao = sqlSession.getMapper(RsvDao.class);
		
		model.addAttribute("hDto",hDao.getHDto(Integer.parseInt(request.getParameter("num"))));
		model.addAttribute("hImgDtos",hImgDao.getHImgList(Integer.parseInt(request.getParameter("num"))));
		model.addAttribute("roomsDtos",roomsDao.RoomsList(Integer.parseInt(request.getParameter("num"))));
		model.addAttribute("RsvCheckDto",rsvDao.rsvList((Integer.parseInt(request.getParameter("num"))),"20150915","20150920"));
	}

}
