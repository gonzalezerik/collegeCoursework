package project2;
import java.util.Scanner;
public class DataAnalyze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int samplmax = 0;


		System.out.print("Please enter the sample size: ");
		samplmax = input.nextInt();

		int[] arr1 = new int[samplmax];
		int[] arr2 = new int[samplmax];
		int[] arr3 = new int[samplmax];
		int[] arr4 = new int[samplmax];

		float min=0;
		float max=0;
		float total1 =0,total2=0,total3=0,total4=0;
		float avg1=0,avg2=0,avg3=0,avg4=0;

		if (samplmax<=0)
			System.out.print("No data to analyze. Ending program.");
		
		else {

			for (int i = 0; i < 4; i++) {
				System.out.println("\nEnter numbers for Trial " + (i + 1) );
				
				if (i==0) {													
					for (int sampl = 1; sampl <= samplmax; sampl++) {
						System.out.print("Enter sample #" + sampl + ": ");
						arr1[sampl - 1] = input.nextInt();
						total1 =(arr1[sampl - 1] + total1);
					}
					System.out.println();

					avg1= (total1/samplmax);	

					min = avg1;
					max = avg1;
				}
				
				if(i == 1) {
					for (int sampl = 1; sampl <= samplmax; sampl++) {
						System.out.print("Enter sample #" + sampl + ": ");
						arr2[sampl - 1] = input.nextInt();
						total2 =(arr2[sampl - 1] + total2);
					}
					System.out.println();	
					avg2= (total2 / samplmax);

					if (max < avg2)
						max = avg2;

					if (min > avg2)
						min = avg2;
				}
				if(i == 2) {
					for (int sampl = 1; sampl <= samplmax; sampl++) {
						System.out.print("Enter sample #" + sampl + ": ");
						arr3[sampl - 1] = input.nextInt();

						total3 =(arr3[sampl - 1] + total3);
					}
					avg3= (total3 / samplmax);	

					System.out.println();

					if (max < avg3)
						max = avg3;
					if (min >avg3)
						min = avg3;
				}
				if(i == 3) {
					for (int sampl = 1; sampl <= samplmax; sampl++) {
						System.out.print("Enter sample #"+ sampl + ": ");
						arr4[sampl - 1] = input.nextInt();

						total4 =(arr4[sampl - 1] + total4);
					}
					System.out.println();

					avg4= (total4 / samplmax);	

					if (max < avg4)
						max = avg4;
					if (min > avg4)
						min = avg4;
				}
			}

			System.out.println("\tSample #\tTrial 1\tTrial 2\tTrial 3\tTrial 4"); 

			for (int i = 0; i< samplmax; i++) {
				System.out.println("\t"+(i + 1) +"\t\t" + arr1[i] + "\t" + arr2[i] + "\t" + arr3[i] + "\t" + arr4[i]);
			}
			System.out.print("\t--------------------------------------------------");
			System.out.println("\nAverages: \t\t" + avg1 + "\t" + avg2 + "\t" + avg3 + "\t" + avg4);

			System.out.printf("\n%-13s%.1f%n", "Min Average:", min);

			System.out.printf("%-13s%.1f%n", "Max Average:", max);

			if(max == min) {
				System.out.print("\nThe trials match EXACTLY!");
			}
			else if (max < (2 * min)) {
				System.out.print("\nThe trials concur with each other!");
			}	
			else {
				System.out.print("\nThe trials do NOT concur!");
			}
		}
	}
}


