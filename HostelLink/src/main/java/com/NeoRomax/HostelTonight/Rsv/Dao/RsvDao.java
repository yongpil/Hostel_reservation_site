package com.NeoRomax.HostelTonight.Rsv.Dao;

import java.util.List;

import com.NeoRomax.HostelTonight.Rsv.Dto.RsvCheckDto;


public interface RsvDao {
	public List<RsvCheckDto> rsvList(int num, String dayfrom, String dayto);
	public boolean RsvConfirm(int hOSTELNUM, int rOOMNUM, String uSERID, String rESERVATIONDAYS, int tOTALRAT);
}
