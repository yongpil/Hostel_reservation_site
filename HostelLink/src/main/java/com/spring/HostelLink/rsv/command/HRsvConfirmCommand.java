package com.spring.HostelLink.rsv.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.spring.HostelLink.command.HCommand;
import com.spring.HostelLink.rsv.dao.RsvDao;
import com.spring.HostelLink.rsv.dto.RsvConfirmDto;
import com.spring.HostelLink.util.Constant;


public class HRsvConfirmCommand implements HCommand {
	SqlSession sqlSession = null;
	
	public HRsvConfirmCommand() {
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
