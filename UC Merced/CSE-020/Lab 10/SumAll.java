import java.util.Scanner;
public class SumAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kbd = new Scanner(System.in);
		int max, sum = 0, loop = 0;
		
		System.out.println("This program will find the sum of all numbers till a specified maximum.");
		
		System.out.print("\nPlease enter the max amount of numbers to add: ");
		max = kbd.nextInt();
		
		while (loop != max + 1) {
			System.out.println("Number " + loop);
			sum = sum + loop;
			loop++;
		}
		
		System.out.println("\nThe sum of all numbers from 0 till "+ max + " is: " + sum + ".");
	}
	

}
