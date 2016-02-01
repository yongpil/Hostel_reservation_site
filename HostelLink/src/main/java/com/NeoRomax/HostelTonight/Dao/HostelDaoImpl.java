package com.NeoRomax.HostelTonight.Dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Dao
* 3. 파일명 : HostelDaoImpl.java
* 4. 작성일 : 2016. 2. 1. 오후 3:04:04
* 5. 작성자 : nick
* 6. 설명 : 리뷰 정보를 불러오기 위한 DAO
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


