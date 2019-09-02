package com.himtube.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.himtube.entity.HimTubeUser;

public class HimTubeDAO implements HimTubeDAOInterface{

	public static HimTubeDAOInterface createDAOobject(String string) {
		// TODO Auto-generated method stub
		return new HimTubeDAO();
	}

	@Override
	public int createProfileDAO(HimTubeUser htu)  {
		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//jdbc:oracle:thin:@//localhost:1522/XE
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Zensar123");
			PreparedStatement ps = con.prepareStatement("Insert into himtube_users values(?,?,?,?,?)");
			ps.setString(1, htu.getName());
			ps.setString(2, htu.getEmail());
			ps.setString(3, htu.getPass());
			ps.setString(4, htu.getDob());
			ps.setString(5, htu.getContact());
			
			i = ps.executeUpdate();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return 1;
	}

}
