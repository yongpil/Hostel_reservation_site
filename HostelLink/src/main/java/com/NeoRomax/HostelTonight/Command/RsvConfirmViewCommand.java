package com.NeoRomax.HostelTonight.Command;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.Dao.HostelDao;
import com.NeoRomax.HostelTonight.Dao.RsvDao;

import util.Constant;


/**
* <pre>
* 1. ������Ʈ�� : HostelTonight
* 2. ��Ű����(�Ǵ� ���丮 ���) : com.NeoRomax.HostelTonight.Command
* 3. ���ϸ� : RsvConfirmViewCommand.java
* 4. �ۼ��� : 2016. 2. 1. ���� 1:56:18
* 5. �ۼ��� : nick
* 6. ���� : ����� �������� �ٽ� DB�� ���� ������ Ȯ�� �ϴ� Ŭ����
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
