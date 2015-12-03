package com.NeoRomax.HostelTonight.HostelList.Command;




import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.HostelList.Dao.HostelDao;
import com.NeoRomax.HostelTonight.HostelList.Dao.ImgDao;
import com.NeoRomax.HostelTonight.util.Constant;

/**
 * <PRE>
 * 1. FileName  : HostelListViewCommand.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Command
 * 3. Comment  : 
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 20. 오후 3:45:00
 * </PRE>
 */ 


public class HostelListViewCommand implements HostelListCommand {
	SqlSession sqlSession = null;
	
	public HostelListViewCommand() {
		sqlSession = Constant.sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		
		HostelDao hDao = sqlSession.getMapper(HostelDao.class);
		ImgDao hImgDao = sqlSession.getMapper(ImgDao.class);
		model.addAttribute("hDtos",hDao.Hlist());
		
	}

}
