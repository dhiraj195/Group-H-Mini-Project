package com.velocity.quiz.test;

import java.sql.Connection;
import java.sql.DriverManager;

//Dhiraj
public class ConnectionClass {
	Connection connection = null;
		
	public Connection getConnectionDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;

	}
}
