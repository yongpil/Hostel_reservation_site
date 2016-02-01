package com.NeoRomax.HostelTonight.Command;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <PRE>
 * 1. FileName  : HostelListCommand.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Command
 * 3. Comment  : 각 커맨드 기능을 수행하기 위한 인터페이스
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 20. 오후 3:44:53
 * </PRE>
 */ 


public interface HCommand {

	
	void execute(Model model);
	
}
