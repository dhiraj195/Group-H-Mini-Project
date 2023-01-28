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
		
		boolean ans1 =true;
		int op;
		while(ans1) {
			System.out.println("\t 1) Start Quiz");
			System.out.println("\t 2) Get Student Score");
			System.out.println("\t 3) Show all Student score");
			System.out.print("\t Please select any one of the above : ");
			op = sc.nextInt();
			ans1=false;
			if(op<1 || op>3) {
				ans1=true;
			}else {
				switch(op) {
				case 1: quizStart();
					break;
					
				case 2:System.out.print("\t Enter Student Id : ");
				       String id =sc.next();
					boolean ans =co.getStudent(id);
					if(!ans) {
						System.out.println("\t Student with "+id+" id is not present :");
					}
					break;
						
				case 3:co.getAllStudentData();
					break;
				}
			}
		}
	}
	
	public void quizStart() {
		st =new Student();
		String id = "";
		System.out.println("\t Please provide student details before starting quiz : ");
//		System.out.println();
		boolean ans = true;
		while (ans) {
			System.out.print("\t Please enter your student Id eg:(Velocity101) : ");
			id = sc.next();
			ans = false;
			if (id.length() != 11) {
				System.out.println("\t Please Enter valid student id.. eg:(Velocity101)");
				ans = true;
			}
			boolean op = co.getStudent(id);
			
			if (op) {
				System.out.println("\t Student with Id " + id + " has already taken quiz..");
				System.out.println("\t Students are not allowed to take quiz twice..");
				System.exit(0);
			}
		}

		System.out.print("\t Please enter your name : ");
		String name = sc.next();

		int score = quizCompetition();
		st.setScore(score);
		st.setId(id);
		st.setName(name);
		co.addStudent(st);
	}

	public int quizCompetition() {
		System.out.println("\t Please read all the instruction carefully : ");
		System.out.println("\t 1) you will get 10 mcq questions it is compusory to answer all the question");
		System.out.println("\t 2) for each question you will get 4 options only one answer is correct");
		System.out.println("\t 3) Please give answer in options eg(1,2,3,4) : ");
		int score = co.getQuestions();
		System.out.println();
		System.out.println("\t Exam has been completed..");
		System.out.println("\t Marks and Grade calculation is in progress..");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (score >= 8) {
			System.out.println("\t Class A - " + score);
		} else if (score >= 6 && score < 8) {
			System.out.println("\t Class B - " + score);
		} else if (score == 5) {
			System.out.println("\t Class C - " + score);
		} else {
			System.out.println("\t Class D (Fail) - " + score);
		}
		
		System.out.println();
		System.out.println("\t Grade criteria");
		System.out.println("\t Class A- 8-10\r\n");
		System.out.println("\t Class B- 6-8\r\n");
		System.out.println("\t Class C- 5\r\n");
		System.out.println("\t Class D- <5\r\n");
		return score;
	}
}
