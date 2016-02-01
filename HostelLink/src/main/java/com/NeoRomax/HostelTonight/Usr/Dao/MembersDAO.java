package com.NeoRomax.HostelTonight.Usr.Dao;

import com.NeoRomax.HostelTonight.Usr.Dto.membersDTO;

/**
 * Members Data Access Object
 * @version 1.0
 * @author Yang Jin Seung 
 */
public interface MembersDAO {
	
	public void joinAuthDao(int lastUserNum, String authority);
	public void joinDao(membersDTO memberDto);
	
}
