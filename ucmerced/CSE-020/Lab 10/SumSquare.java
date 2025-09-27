import java.util.Scanner;
public class SumSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kbd = new Scanner(System.in);
		
		int max, sum = 0, num;
		
		System.out.print("Please enter the maximum number: ");
		max = kbd.nextInt();
		
		System.out.print("\n");
		
		for (int i = 0; i < max; i++) {
			num = (i + 1) * (i + 1);
			sum = sum + num;
			System.out.println("Number " + (i + 1) + " squared is " + num);
		}
		System.out.println("\nThe sum of all squares from 1 till " + max + " is: " + sum);
		
		
	}

}
