package com.NeoRomax.HostelTonight.Service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.NeoRomax.HostelTonight.Dao.HostelDao;
import com.NeoRomax.HostelTonight.Dao.HostelDaoImpl;


/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Service
* 3. 파일명 : HostelServiceImpl.java
* 4. 작성일 : 2016. 2. 1. 오후 3:10:04
* 5. 작성자 : nick
* 6. 설명 : 리뷰기능을위한 서비스 클래스
* </pre>
*/
@Service("hostelService")
public class HostelServiceImpl implements HostelService {
	Logger log = LoggerFactory.getLogger(HostelServiceImpl.class);

	@Resource(name="hostelDao")
	private HostelDaoImpl hostelDao;

	@Override
	public List<Map<String, Object>> selectReviewList(int hstNum) throws Exception {

		return hostelDao.selectReviewList(hstNum);
	}

}
