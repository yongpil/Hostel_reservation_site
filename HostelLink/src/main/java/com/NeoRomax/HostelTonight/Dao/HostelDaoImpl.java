package com.NeoRomax.HostelTonight.Dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("hostelDao")
public class HostelDaoImpl {
	@Autowired
	private SqlSessionTemplate sqlSession;


	public List<Map<String,Object>> selectReviewList(int hstNum) { 

		return sqlSession.selectList("hostelDao.selectReviewList",hstNum);
	}

}


