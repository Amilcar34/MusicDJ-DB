package com.musicdj.dao;

import java.util.List;

import com.musicdj.enteties.Client;

public interface ITransaction extends IConnection{

	List<Client> read();
	
	public boolean update(int id, String name, String musicGen);

	public boolean create(String name, String musicGen);
	
	public boolean delete(int id);
	
}
