import java.util.Scanner;

public class RemainderFunc {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		int maximum, divisor;
		
		System.out.print("Please enter the max number: ");
		maximum = input.nextInt();
		
		if (maximum <=  0) {
			while (maximum <= 0) {
				System.out.print("Invalid input. Please enter a valid max number (>= 0): ");
				maximum = input.nextInt();
			}
		}
		
		System.out.print("Please enter the divsor: ");
		divisor = input.nextInt();
		
		if (divisor <=  0) {
			while (divisor <= 0) {
				System.out.print("Invalid input. Please enter a valid divisor (> 0): ");
				divisor = input.nextInt();
			}
		}
		
		
		
		
		int count = divisor;
		
		
		if (divisor > maximum) {
			System.out.print("No number were found.");
		}
		
		else if (maximum > divisor) {
			System.out.println("Multiples of " + divisor + " between 1 and " + maximum + " (Inclusive) are: ");
			for (int i = 0; i <= maximum; i++) {
				if (maximum > divisor) {
					if (i % divisor == 0) {
						System.out.println(divisor);
						divisor += count;
					}
				}
			
			}
		}

	}
}
