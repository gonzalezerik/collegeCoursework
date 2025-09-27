import java.util.Scanner;
public class Multiples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kbd = new Scanner(System.in);

		int max, multi,loop = 1;
		
		System.out.println("This program prints out multiples of a given number till a specified maximum.");
		
		System.out.print("\nPlease enter the maximum number: ");
		max = kbd.nextInt();
		
		System.out.print("Please enter the number whose multiples to print: ");
		multi = kbd.nextInt();
		
		System.out.println("Multiples of " + multi + " from 1 till " + max + " are:");
		
		while (loop != max + 1) {
			if (loop % multi == 0)
				System.out.println(loop);
			loop++;
		}
	}

}
