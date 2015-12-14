package com.NeoRomax.HostelTonight.Service;

import java.util.List;
import java.util.Map;

public interface HostelService {

	List<Map<String, Object>> selectReviewList(int hstNum)throws Exception;

}
