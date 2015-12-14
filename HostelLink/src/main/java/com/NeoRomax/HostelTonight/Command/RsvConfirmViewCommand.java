package com.NeoRomax.HostelTonight.Command;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.Dao.RsvDao;

import util.Constant;

public class RsvConfirmViewCommand implements HCommand {
	SqlSession sqlSession = null;
	
	public RsvConfirmViewCommand() {
		sqlSession = Constant.sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int rsvNumParam = (Integer) map.get("rsvNum");
		
		RsvDao rsvDao = sqlSession.getMapper(RsvDao.class);
		model.addAttribute("RsvList",rsvDao.getRsvList(rsvNumParam));

	}

}
