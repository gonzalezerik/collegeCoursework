import java.util.Scanner;

public class manipulate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);

		//Short 
		short n1;
		short n2;
		
		System.out.println("Input short numbers: ");
		
		n1 = input.nextShort();
		n2 = input.nextShort();
		
		short sum = (short) (n1 + n2);
		System.out.println("The sum of " + n1 + " and " + n2 + " is: " + sum);
		
		short diff = (short) (n1 - n2);
		System.out.println("The difference of " + n1 + " and " + n2 + " is: " + diff);

		short prod = n1 * n2;
		System.out.println("The product of " + n1 + " and " + n2 + " is: " + prod);
		
		short intCast = n1 / n2;
		System.out.println("The sum of " + n1 + " and " + n2 + " is: " + intCast);
		
		short intCast2 = n1 % n2;
		System.out.println("The sum of " + n1 + " and " + n2 + " is: " + intCast2);
		
		
		
		//Scanner intput2 = new Scanner(System.in);
		
		float n3;
		float n4;
		
		System.out.println("\nInput two floating numbers: ");
		
		n3 = input.nextFloat();
		n4 = input.nextFloat();
		
		float sum1 = n3 + n4;
		System.out.println("The sum of " + n3 + " and " + n4 + " is: " + sum1);
		
		float diff1 = n3 - n4;
		System.out.println("The difference of " + n3 + " and " + n4 + " is: " + diff1);

		float prod1 = n3 * n4;
		System.out.println("The product of " + n3 + " and " + n4 + " is: " + prod1);
		
		float intCast1 = n3 / n4;
		System.out.println("The sum of " + n3 + " and " + n4 + " is: " + intCast1);
		
		float intCast21 = n3 % n4;
		System.out.println("The sum of " + n3 + " and " + n4 + " is: " + intCast21);
		
		//double
		double n5;
		double n6;
		
		System.out.println("\nInput two doubles: ");
		
		n5 = input.nextDouble();
		n6 = input.nextDouble();
		
		double sum11 = n5 + n6;
		System.out.println("The sum of " + n5 + " and " + n6 + " is: " + sum11);
		
		double diff11 = n5 - n6;
		System.out.println("The difference of " + n5 + " and " + n6 + " is: " + diff11);

		double prod11 = n5 * n6;
		System.out.println("The product of " + n5 + " and " + n6 + " is: " + prod11);
		
		double intCast11 = n5 / n6;
		System.out.println("The sum of " + n5 + " and " + n6 + " is: " + intCast11);
		
		double intCast211 = n5 % n6;
		System.out.println("The sum of " + n5 + " and " + n6 + " is: " + intCast211);
		
		
	}

}
