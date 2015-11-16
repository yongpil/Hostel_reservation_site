package com.spring.HostelLink.rsv.dao;

import java.util.List;

import com.spring.HostelLink.rsv.dto.RsvCheckDto;


public interface RsvDao {
	public List<RsvCheckDto> rsvList(int num, String dayfrom, String dayto);
	public boolean RsvConfirm(int hOSTELNUM, int rOOMNUM, String uSERID, String rESERVATIONDAYS, int tOTALRAT);
}
