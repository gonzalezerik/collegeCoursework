import java.util.Scanner;
public class AnyAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kbd = new Scanner(System.in);
		
		int avg,num, sum = 0, loop = 1;
		
		System.out.println("This program will find the average of as many numbers as you like.");
		
		System.out.print("\nPlease choose the number of values to average: ");
		avg = kbd.nextInt();
		System.out.print("\n");
		while (loop != avg + 1) {
			System.out.print("Please enter the " + loop + " number: ");
			num = kbd.nextInt();
			
			sum = sum + num;
			loop++;
			
		}
		
		System.out.println("The average of all the numbers is: " + (double)(sum / avg));
	}

}
