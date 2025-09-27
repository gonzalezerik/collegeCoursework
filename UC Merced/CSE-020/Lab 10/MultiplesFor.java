import java.util.Scanner;

public class MultiplesFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kbd = new Scanner(System.in);

		int max, mul,loop = 1;
		
		System.out.println("This program prints out multiples of a given number till a specified maximum.");
		
		System.out.print("\nPlease enter the maximum number: ");
		max = kbd.nextInt();
		
		System.out.print("Please enter the number whose multiples to print: ");
		mul = kbd.nextInt();
		
		System.out.println("Multiples of " + mul + " from 1 till " + max + " are:");
		
		for (int i = 0; i <= max; i++) {
			if (loop % mul == 0)
				System.out.println(loop);
			loop++;
		}
	}

}
