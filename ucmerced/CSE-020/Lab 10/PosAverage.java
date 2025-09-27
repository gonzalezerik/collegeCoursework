import java.util.Scanner;
public class PosAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kbd = new Scanner(System.in);
		
		int loop = 1, sum = 0, num;
		double avg;
		
		System.out.println("Enter 0 or less to stop entering numbers.");
		
		do {
			System.out.print("Enter value #" + (loop) + ": ");
			num = kbd.nextInt();
			sum = sum + num;
			loop++;
		}while (num < 0 || num != 0);
		
		avg = (double)(sum / (loop - 1));
		System.out.print("Average is " + avg);
	}

}
