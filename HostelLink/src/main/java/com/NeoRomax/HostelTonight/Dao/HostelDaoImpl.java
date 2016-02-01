package com.NeoRomax.HostelTonight.Dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
* <pre>
* 1. ������Ʈ�� : HostelTonight
* 2. ��Ű����(�Ǵ� ���丮 ���) : com.NeoRomax.HostelTonight.Dao
* 3. ���ϸ� : HostelDaoImpl.java
* 4. �ۼ��� : 2016. 2. 1. ���� 3:04:04
* 5. �ۼ��� : nick
* 6. ���� : ���� ������ �ҷ����� ���� DAO
* </pre>
*/
@Repository("hostelDao")
public class HostelDaoImpl {
	@Autowired
	private SqlSessionTemplate sqlSession;


	public List<Map<String,Object>> selectReviewList(int hstNum) { 

		return sqlSession.selectList("hostelDao.selectReviewList",hstNum);
	}

}


