package com.velocity.quiz.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CrudOperation {

	Connection conn = null;
	PreparedStatement ps = null;
	Scanner sc = new Scanner(System.in);

	// Dhiraj
	public void getAllStudentData() {
		try {
			ConnectionClass cc = new ConnectionClass();
			conn = cc.getConnectionDetails();
			ps = conn.prepareStatement("SELECT * FROM student");
			ResultSet rs = ps.executeQuery();
			System.out.println();
			System.out.println("\t Student Id \t\t Student Name \t\t Score");
			while (rs.next()) {
				System.out.println("\t " + rs.getString(1) + "\t\t " + rs.getString(2) + "\t\t " + rs.getInt(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	// Dhiraj
	public void addStudent(Student st) {
		try {
			ConnectionClass cc = new ConnectionClass();
			conn = cc.getConnectionDetails();
			ps = conn.prepareStatement("insert into student(Studid,StudentName,Score) values(?,?,?)");
			ps.setString(1, st.getId());
			ps.setString(2, st.getName());
			ps.setInt(3, st.getScore());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public boolean getStudent(String id) {
		boolean ans = false;
		try {
			ConnectionClass cc = new ConnectionClass();
			conn = cc.getConnectionDetails();
			ps = conn.prepareStatement("SELECT * FROM student WHERE Studid = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			ans = false;
			while (rs.next()) {
				ans = true;
				System.out.println("\t Name : " + rs.getString(2));
				System.out.println("\t Score : " + rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}

	public int getQuestions() {
		int score = 0;
		try {
			ConnectionClass cc = new ConnectionClass();
			conn = cc.getConnectionDetails();
			ps = conn.prepareStatement("SELECT * FROM questions ORDER BY RAND()");
			ResultSet rs = ps.executeQuery();

			boolean ans = true;
			int op = 0;

			while (rs.next()) {
				System.out.println();
				System.out.println("\t Q) " + rs.getString(2));
				System.out.println();
				System.out.println("\t 1) " + rs.getString(3));
				System.out.println("\t 2) " + rs.getString(4));
				System.out.println("\t 3) " + rs.getString(5));
				System.out.println("\t 4) " + rs.getString(6));

				while (ans) {

					System.out.print("\t Answer : ");
					op = sc.nextInt();
					ans = false;
					if (op<1 || op>4) {
						ans = true;
						System.out.println("\t Wrong output please give correct output between 1 to 4 ");
					}
				}
				if (rs.getString(op + 2).contains(rs.getString(7))) {
					score++;
				}
				ans = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return score;
	}

}
