
import java.util.Scanner;

public class Interviewer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String name;
		//String hob;
		//String campus;
		//String color;
		int num;
		float heightIn;
		Scanner input = new Scanner(System.in);
		
		System.out.print("What is your name? ");
		String name = input.nextLine();
		
		System.out.print("What is your favorite number?: ");
		num = input.nextInt();
		
		input.nextLine();
		
		System.out.print("What are your hobbies?: ");
		String hob = input.nextLine();
		
		input.nextLine();
		
		System.out.print("Do you live on or off campus?: ");
		String campus = input.nextLine();
		
		input.nextLine();

		System.out.print("What is your favorite color?: ");
		String color = input.next();
		
		System.out.print("What is your height in inches?: ");
		heightIn = input.nextFloat();
	
		System.out.print("\nSo your name is " + name + ".");
		System.out.print(" Your favorite number is " + num + ".");
		System.out.print(" You like to " + hob + ".");
		System.out.print(" You live " + campus + ".");
		System.out.print(" \nYou favorite color is " + color + ".");
		
		
		float heightCm = heightIn * (float) 2.54;
		System.out.print(" Your height in centimeters is " + heightCm + ".");
		
				
	}

}
