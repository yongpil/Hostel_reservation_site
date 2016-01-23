package com.NeoRomax.HostelTonight.Service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.NeoRomax.HostelTonight.Dao.HostelDao;
import com.NeoRomax.HostelTonight.Dao.HostelDaoImpl;


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
