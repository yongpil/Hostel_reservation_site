package com.NeoRomax.HostelTonight.Command;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <PRE>
 * 1. FileName  : HostelListCommand.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Command
 * 3. Comment  : �� Ŀ�ǵ� ����� �����ϱ� ���� �������̽�
 * 4. �ۼ���   : "Yong Pil Moon"
 * 5. �ۼ���   : 2015. 11. 20. ���� 3:44:53
 * </PRE>
 */ 


public interface HCommand {

	
	void execute(Model model);
	
}
