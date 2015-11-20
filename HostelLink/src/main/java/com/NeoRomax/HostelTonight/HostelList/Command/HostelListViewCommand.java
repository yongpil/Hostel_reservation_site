package com.NeoRomax.HostelTonight.HostelList.Command;




import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.HostelList.Dao.HostelListHostelDao;
import com.NeoRomax.HostelTonight.HostelList.Dao.HostelListImgDao;
import com.NeoRomax.HostelTonight.util.Constant;

/**
 * <PRE>
 * 1. FileName  : HostelListViewCommand.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Command
 * 3. Comment  : 
 * 4. �ۼ���   : "Yong Pil Moon"
 * 5. �ۼ���   : 2015. 11. 20. ���� 3:45:00
 * </PRE>
 */ 


public class HostelListViewCommand implements HostelListCommand {
	SqlSession sqlSession = null;
	
	public HostelListViewCommand() {
		sqlSession = Constant.sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		
		HostelListHostelDao hDao = sqlSession.getMapper(HostelListHostelDao.class);
		HostelListImgDao hImgDao = sqlSession.getMapper(HostelListImgDao.class);
		model.addAttribute("hDtos",hDao.Hlist());
		
	}

}
