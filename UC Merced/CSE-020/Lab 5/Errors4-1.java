import java.util.Scanner;

public class Errors4 {

	public static void main(String[] args) {
		//Lines that are commented out are the original code that was fixed.
		
		int n1, n2;

		Scanner kbd = new Scanner(System.in);

		System.out.println("This program asks the user for two integers and calculates their sum as an integer.");

		//kbd = new Scanner(System.in);

		//n1 = kbd.nextInt();

		System.out.print("Enter the first number: ");
		n1 = kbd.nextInt();
		
		System.out.print("Enter the second number: ");
		n2 = kbd.nextInt();
		//n2 = kbd.nextShort();
		System.out.println("The sum of the numbers is " + (int)(n1+n2));
		//System.out.println("The sum of the numbers is " + (float)(n1+n2));
	}

}