package com.spring.HostelLink.command;




import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.spring.HostelLink.dao.HDao;
import com.spring.HostelLink.dao.HImgDao;
import com.spring.HostelLink.util.Constant;

public class HListCommand implements HCommand {
	SqlSession sqlSession = null;
	
	public HListCommand() {
		sqlSession = Constant.sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		
		HDao hDao = sqlSession.getMapper(HDao.class);
		HImgDao hImgDao = sqlSession.getMapper(HImgDao.class);
		model.addAttribute("hDtos",hDao.Hlist());
		
	}

}
