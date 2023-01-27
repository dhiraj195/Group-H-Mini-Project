package com.velocity.quiz.test;

import java.util.Scanner;

public class Quiz {

	Scanner sc = null;
	CrudOperation co = null;
	Student st = null;

	public void homePage() {
		sc = new Scanner(System.in);
		co = new CrudOperation();
		System.out.println("");
		System.out.println("\t Welcome to the quiz competition ");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String id = "";
		System.out.println("\t Please provide student details before starting quiz : ");
		System.out.println();
		boolean ans = true;
		while (ans) {
			System.out.println("\t Please enter your student Id eg:(Velocity101) ");
			id = sc.nextLine();
			ans = false;
			if (id.length() != 11) {
				System.out.println("\t Please Enter valid student id.. eg:(Velocity101)");
				ans = true;
			}
			if (co.getStudent(id)) {
				System.out.println("\t Student with Id " + id + " has already taken quiz..");
				System.out.println("\t Students are not allowed to take quiz twice..");
				System.exit(0);
			}
		}

		System.out.println("\t Please enter your name ");
		String name = sc.nextLine();

		int score = quizCompetition();
		st.setScore(score);
		st.setId(id);
		st.setName(name);

		co.addStudent(st);

	}

	public int  quizCompetition() {
		System.out.println("\t Please read all the instruction carefully : ");
		System.out.println("\t 1) you will get 10 mcq questions it is compusory to answer all the question");
		System.out.println("\t 2) for each question you will get 4 options only one answer is correct");
		
		return 0;
	}
}
