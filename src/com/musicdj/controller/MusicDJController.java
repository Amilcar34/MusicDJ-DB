package com.musicdj.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.musicdj.dao.IConnection;
import com.musicdj.dao.ITransaction;
import com.musicdj.enteties.Client;

public class MusicDJController implements ITransaction {

	@Override
	public List<Client> read() {

		int id = 0;
		String name = null;
		String musicgen = null;

		List<Client> listOfClients = new ArrayList<>();
		try {
			IConnection ic = new IConnection() {};
			Connection con = ic.getConnection();

			if (con != null) {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM clients");

				while (rs.next()) {
					id = rs.getInt("id");
					name = rs.getString("name");
					musicgen = rs.getString("musicgen");
					listOfClients.add(new Client(id, name, musicgen));
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfClients;
	}

	@Override
	public boolean create(String name, String musicGen) {

		boolean created = false;
		
		try {
			IConnection ic = new IConnection() {};
			Connection con = ic.getConnection();
					
			if (con != null) {
				PreparedStatement ps;
				String sql = "INSERT INTO clients(name, musicgen) VALUES(?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, musicGen);
				ps.execute();
				ps.close();
				created = true;

			} else {
				System.out.println("Connection are null");
				created = false;
			}
		} catch (SQLException e) {
			System.out.println("Unable to connect");
			e.printStackTrace();
		}
		return created;
	}

	@Override
	public boolean update(int id, String name, String musicGen) {

		boolean update = false;
		
		try {
			IConnection ic = new IConnection(){};
			Connection con = ic.getConnection();
			
			if(con != null){
				PreparedStatement ps = null;
				String sql = "UPDATE clients SET name=? , musicgen=? WHERE id= ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, musicGen);
				ps.setInt(3, id);
				ps.execute();
				ps.close();
				update = true;
			}else{
				System.err.println("No se realizo la coneccion a la DB");
				update = false;
			}
				
		} catch (Exception e) {
			System.err.println("Unable to connect");
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public boolean delete(int id) {

		boolean delete = false;
		
		try {
			IConnection ic = new IConnection(){};
			Connection con = ic.getConnection();
			
			if(con != null){
				PreparedStatement ps = null;
				String sql = "DELETE FROM clients WHERE id=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
				ps.close();
				delete = true;
				
			}else{
				System.out.println("Unable to execute Query");
				delete = false;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Unable even connect");
			e.printStackTrace();
		}
		return delete;
	}

}
