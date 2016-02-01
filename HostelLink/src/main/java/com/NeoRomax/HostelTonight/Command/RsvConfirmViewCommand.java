package com.NeoRomax.HostelTonight.Command;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.Dao.HostelDao;
import com.NeoRomax.HostelTonight.Dao.RsvDao;

import util.Constant;


/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Command
* 3. 파일명 : RsvConfirmViewCommand.java
* 4. 작성일 : 2016. 2. 1. 오후 1:56:18
* 5. 작성자 : nick
* 6. 설명 : 예약된 정보들을 다시 DB로 부터 가져와 확인 하는 클래스
* </pre>
*/
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
		HostelDao hDao = sqlSession.getMapper(HostelDao.class);
		
		model.addAttribute("RsvList",rsvDao.getRsvList(rsvNumParam));
		model.addAttribute("hDto",hDao.getHDto(rsvDao.getRsvList(rsvNumParam).getHostelNum()));
	}

}
