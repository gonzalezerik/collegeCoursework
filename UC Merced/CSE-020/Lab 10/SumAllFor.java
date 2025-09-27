import java.util.Scanner;

public class SumAllFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner kbd = new Scanner(System.in);
		
			int max, sum = 0, loop = 0;
			
			System.out.println("This program will find the sum of all numbers till a specified maximum.");
			
			System.out.print("\nPlease enter the max amount of numbers to add: ");
			max = kbd.nextInt();
			
			for (int i = 0; i <= max; i++) {
				System.out.println("Number " + loop);
				sum = sum + loop;
				loop++;
			}
			
			System.out.println("\nThe sum of all numbers from 0 till "+ max + " is: " + sum + ".");

	}

}
