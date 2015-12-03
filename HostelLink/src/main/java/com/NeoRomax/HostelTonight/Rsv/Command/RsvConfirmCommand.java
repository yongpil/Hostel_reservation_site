package com.NeoRomax.HostelTonight.Rsv.Command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.HostelList.Command.HostelListCommand;
import com.NeoRomax.HostelTonight.HostelList.Dto.SessionDto;
import com.NeoRomax.HostelTonight.Rsv.Dao.RsvDao;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvConfirmDto;
import com.NeoRomax.HostelTonight.util.Constant;


/**
 * <PRE>
 * 1. FileName  : RsvConfirmCommand.java
 * 2. Package  : com.NeoRomax.HostelTonight.Rsv.Command
 * 3. Comment  : 
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 20. 오후 3:45:25
 * </PRE>
 */ 


public class RsvConfirmCommand implements HostelListCommand {
	SqlSession sqlSession = null;
	
	public RsvConfirmCommand() {
		sqlSession = Constant.sqlSession;
	}
	@Override
	public void execute(Model model) { 
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		SessionDto sessionDto = (SessionDto) map.get("sessionDto");
		
		RsvDao rsvDao = sqlSession.getMapper(RsvDao.class);
		String UserId = request.getParameter("userId");
		
		

	}

}
