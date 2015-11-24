package com.NeoRomax.HostelTonight.Usr.Dao;

import java.util.ArrayList;

import javax.naming.directory.SearchResult;

/**
 * Members Data Access Object
 * @version 1.0
 * @author Yang Jin Seung 
 */
public interface SearchDAO {
	
	public ArrayList<SearchResult> autoCompleteDao(String keyword);
	
}
