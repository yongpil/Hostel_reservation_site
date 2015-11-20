package com.NeoRomax.HostelTonight.Rsv.Dao;

import java.util.List;

import com.NeoRomax.HostelTonight.Rsv.Dto.RsvCheckDto;


/**
 * <PRE>
 * 1. FileName  : RsvDao.java
 * 2. Package  : com.NeoRomax.HostelTonight.Rsv.Dao
 * 3. Comment  : 
 * 4. �ۼ���   : "Yong Pil Moon"
 * 5. �ۼ���   : 2015. 11. 20. ���� 3:45:39
 * </PRE>
 */ 


public interface RsvDao {
	public List<RsvCheckDto> rsvList(int num, String dayfrom, String dayto);
	public boolean RsvConfirm(int hOSTELNUM, int rOOMNUM, String uSERID, String rESERVATIONDAYS, int tOTALRAT);
}
