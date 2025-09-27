import java.util.Scanner;

public class AnyAverageArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		System.out.print("Please choose number of values to average: ");

		int max = input.nextInt();

		System.out.print("Please choose column width for output formatting: ");
		int col = input.nextInt();

		System.out.println("");
		int[] array = new int[max];
		int val;


		// For-loop to calculate sums
		for (int i = 0; i <= max - 1; i++) {
			System.out.print("Please enter value # " + (i + 1) + ": ");
			val = input.nextInt();
			array[i] = val;
		}
		int l = 0;
		int count = 0;
		System.out.println("\nThe numbers being averaged are ... ");

		for (int i = 0; i <= max - 1; i++) {
			l = 0;
			while (l != 4) {
				for (l = l; l < col; l++) {
					if (count >= max) {
						break;
					}
					System.out.print(array[count] + " ");
					count++;
				}
				System.out.print("\n");
				if (count >= max) {
					break;
				}
			}
		}
		
		double sum = 0;
		
		for (int i = 0; i <= max - 1; i++) {
			
			sum = sum + array[i];
		}
		System.out.println ("Average is: " + (double) (sum / max));

	}
	
}
