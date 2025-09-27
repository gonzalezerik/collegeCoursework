import java.util.Scanner;

public class Errors6 {

	public static void main(String[] args) {
		System.out.println("This program will ask the user for three sets of two numbers and will calculate the average of each set.");

		Scanner input = new Scanner(System.in);

		int n1, n2;

		System.out.print("Please enter the first int number: ");
		//added int to the output
		n1 = input.nextInt();

		System.out.print("Please enter the second int number: ");
		//added int to the ouput
		n2 = input.nextInt();

		int average;
		average = (n1+n2)/2;
		System.out.println("The average of the numbers is " + average);

		//Scanner input = new Scanner(System.in);

		float a3, a4;
		//float n1, n2

		System.out.print("Please enter the first float number:");
		//added float to the output
		a3 = input.nextFloat();
		//n1 = input.nextFloat();
		
		System.out.print("Please enter the second float number: ");
		//added float to the output
		a4 = input.nextFloat();
		//n2 = input.nextFloat();
		
		float fAverage;
		//float average;
		
		fAverage = (float)(a3 + a4)/2;
		//average = (n1+n2)/2
		
		System.out.println("The average of the numbers is " + fAverage);
		//System.out.print("The average of the numbers is " + average);

		short s1, s2;

		System.out.print("Please enter the first short number: ");
		//added "Short to the output"
		s1 = input.nextShort();
	

		System.out.print("Please enter the second short number: ");
		//added "short to the output"
		s2 = input.nextShort();

		int shortAvg;
		//shortAvg;
		shortAvg = (short)(s1 + s2)/ 2;
		
		//shortAvg = (short)(n1+n2)/2;
		System.out.print("The average of the numbers is " + shortAvg);
	}

}
