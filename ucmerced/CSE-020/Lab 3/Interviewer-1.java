package lab20_03;

import java.util.Scanner;

public class Interviewer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name;
		String lang;
		String why;
		String workExp;
		int gradYear;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your name? ");
		name = input.next();
		
		System.out.println("What year did you graduate? ");
		gradYear = input.nextInt();
		
		System.out.println("What programming language(s) are you most comfortable? ");
		lang = input.next();
		
		System.out.println("Why do you want to work for us?");
		why = input.next();
		
		System.out.println(" Have you have any prior work experience?");
		workExp = input.next();
	
	}

}
