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
* 1. ������Ʈ�� : HostelTonight
* 2. ��Ű����(�Ǵ� ���丮 ���) : com.NeoRomax.HostelTonight.Service
* 3. ���ϸ� : HostelServiceImpl.java
* 4. �ۼ��� : 2016. 2. 1. ���� 3:10:04
* 5. �ۼ��� : nick
* 6. ���� : ������������ ���� Ŭ����
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
