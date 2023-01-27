package com.velocity.quiz.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudOperation {

	Connection conn = null;
	PreparedStatement ps = null;

	public boolean getStudent(String id) {
		boolean ans = false;
		try {
			ConnectionClass cc = new ConnectionClass();
			conn = cc.getConnectionDetails();
			ps = conn.prepareStatement("select * from user where LastName = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs == null) {
				ans = false;
			} else {
				ans = true;
				while (rs.next()) {
					System.out.println("Name : " + rs.getString(3));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}
	
	//Dhiraj
	public void addStudent(Student st) {
		
	}
}
