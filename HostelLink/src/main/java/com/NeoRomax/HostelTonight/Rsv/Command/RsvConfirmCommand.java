package com.NeoRomax.HostelTonight.Rsv.Command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.HostelList.Command.HostelListCommand;
import com.NeoRomax.HostelTonight.Rsv.Dao.RsvDao;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvConfirmDto;
import com.NeoRomax.HostelTonight.util.Constant;


public class RsvConfirmCommand implements HostelListCommand {
	SqlSession sqlSession = null;
	
	public RsvConfirmCommand() {
		sqlSession = Constant.sqlSession;
	}
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int hostelNum = Integer.parseInt(request.getParameter("hstNum"));
		String UserId = request.getParameter("userId");

		RsvDao rsvDao = sqlSession.getMapper(RsvDao.class);
		
		for(int i=0;i<Integer.parseInt(request.getParameter("listSize"));i++)
		{
			RsvConfirmDto rsvConBean = new RsvConfirmDto();
			
			rsvConBean.setROOMNUM(Integer.parseInt(request.getParameter("rsvConfirmData" + String.valueOf(i*5+1))));
			rsvConBean.setRESERVATIONDAYS(request.getParameter("rsvConfirmData" + String.valueOf(i*5+2)));
			rsvConBean.setTOTALRATE(Integer.parseInt(request.getParameter("rsvConfirmData" + String.valueOf(i*5+3))));
			
			rsvDao.RsvConfirm(hostelNum,rsvConBean.getROOMNUM(),UserId,rsvConBean.getRESERVATIONDAYS(),rsvConBean.getTOTALRATE());
		}

	}

}
