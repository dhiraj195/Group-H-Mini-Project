package com.velocity.quiz.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	Connection connection = null;
	
	//Dhiraj
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
