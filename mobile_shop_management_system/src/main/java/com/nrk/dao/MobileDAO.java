package com.nrk.dao;

import java.util.List;

import com.nrk.model.Mobile;

public interface MobileDAO {
	
	public void save(Mobile p);
	public List<Mobile> list();
	public Mobile getName(String name);
	public int delete(String name);
	public Mobile getImage(String name);

}
