import java.util.Scanner;

public class Number {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter a number 1-26: ");
		int num = input.nextInt();
		//changed double to int
		
		if (num > 26 || num < 1)
			System.out.println("Invalid Input! Number is outside of acceptable range.");
		else 	
		{
			
			System.out.print("Character " + num + " of the alphabet is " + (char)('A'+ num - 1));
			
		}
		
			

	}

}
