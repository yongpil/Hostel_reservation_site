package com.NeoRomax.HostelTonight.Command;




import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.Dao.AdminDao;
import com.NeoRomax.HostelTonight.Dao.HostelDao;
import com.NeoRomax.HostelTonight.Dto.SchLocationDto;

import util.Constant;


/**
 * <PRE>
 * 1. FileName  : HostelListViewCommand.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Command
 * 3. Comment  : admin������������ Ŀ�ǵ� Ŭ����
 * 4. �ۼ���   : "Yong Pil Moon"
 * 5. �ۼ���   : 2015. 11. 20. ���� 3:45:00
 * </PRE>
 */ 


public class HostelAdminCommand implements HCommand {
	SqlSession sqlSession = null;
	
	public HostelAdminCommand() {
		sqlSession = Constant.sqlSession;
	}
	
	@Override
	public void execute(Model model) {

		AdminDao aDao = sqlSession.getMapper(AdminDao.class);
		model.addAttribute("schLocationDtos",aDao.SchLocationList());
		model.addAttribute("locations",aDao.getLocation());
		
	}

}
