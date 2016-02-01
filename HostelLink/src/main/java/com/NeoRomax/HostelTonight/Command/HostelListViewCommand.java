package com.NeoRomax.HostelTonight.Command;




import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.Dao.HostelDao;

import util.Constant;


/**
 * <PRE>
 * 1. FileName  : HostelListViewCommand.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Command
 * 3. Comment  : 호스텔 리스트 페이지를 위한 클래스, 호스텔 리스트 정보를 불러 온다.
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 20. 오후 3:45:00
 * </PRE>
 */ 


public class HostelListViewCommand implements HCommand {
	SqlSession sqlSession = null;
	
	public HostelListViewCommand() {
		sqlSession = Constant.sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		String lctSearch = (String) map.get("lctSearch");
		
		HostelDao hDao = sqlSession.getMapper(HostelDao.class);
		model.addAttribute("hDtos",hDao.Hlist(lctSearch));
		
	}

}
