package com.NeoRomax.HostelTonight.Usr.Dao;
/**
 * Members Data Access Object
 * @version 1.0
 * @author Yang Jin Seung 
 */
public interface MembersDAO {
	
	public void joinDao(String id, String pwd, String firstName, String lastName, String birth);
	public void joinAuthDao(String authority);
	
}
