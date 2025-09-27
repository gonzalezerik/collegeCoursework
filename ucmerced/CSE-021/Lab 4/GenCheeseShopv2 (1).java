import java.util.Random;
import java.util.Scanner;
public class GenCheeseShopv2 {

	/*
	 * Displays the intro message informing the user of various cheeses sold 
	 * while populating the names and prices arrays, and initializing the
	 * amounts array.
	 */
	public static void intro(String[] names, double[] prices, double[] amounts) {
		// Fill-in
		System.out.println("We sell " + names.length + " kinds of Cheese (in 0.5 lb packages): ");
		if (names.length >= 1) {
			System.out.println("Humboldt Fog: $25.00 per pound  ");
			prices[0] = 25.00;
		}
		if(names.length >= 2) {
			System.out.println("Red Hawk: $40.50 per pound"); 
			prices[1] = 40.50;
		}
		if (names.length >= 3) {
			System.out.println("Teleme: $17.25");
			prices[2] = 17.25;
		}

		if (names.length >= 4) {
			Random ranGen = new Random(100);		

			for (int i = 3; i < names.length; i++) {
				System.out.print("Cheese Type " + (char)('A' + i));
				prices[i] = ranGen.nextInt(1000)/100.0;

				System.out.println(": $" + prices[i] + " per pound");
			}
		}

	}

	/*
	 * Gets the amount of each cheese the user would like to purchase and populates
	 * the amounts array with the user inputs. Performs with input validation 
	 * (amount >= 0 and multiple of 0.5).
	 */
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {
		// Fill-in
		if (names.length >= 1) {
			System.out.print("Enter the amount of Humboldt Fog in lbs:  ");
			amounts[0] = sc.nextDouble();
			while (amounts[0] < 0 && amounts[1] % 0.5 != 0) {
				if (amounts[0] < 0) {
					while (amounts[0] < 0 ) {
						System.out.print("Invalid input. Enter a value >= 0: ");
						amounts[0] = sc.nextDouble();
					}
				}
				if (amounts[0] % 0.5 != 0) {
					while (amounts[0] % 0.5 > 0) {
						System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
						amounts[0] = sc.nextDouble();
					}
				}
			}
		}

		if (names.length >= 2) {
			System.out.print("Enter the amount of Red Hawk in lbs: ");
			amounts[1] = sc.nextDouble();

			while (amounts[1] < 0 || amounts[1] % 0.5 != 0) {
				if (amounts[1] < 0) {
					while (amounts[1] < 0 ) {
						System.out.print("Invalid input. Enter a value >= 0: ");
						amounts[1] = sc.nextDouble();
					}
				}
				if (amounts[1] % 0.5 != 0) {
					while (amounts[1] % 0.5 > 0) {
						System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
						amounts[1] = sc.nextDouble();
					}
				}
			}
		}

		if (names.length >= 3) {
			System.out.print("Enter the amount of Teleme in lbs: ");
			amounts[2] = sc.nextDouble();

			if (amounts[2] < 0 || amounts[2] % 0.5 != 0) {
				while(amounts[2] < 0|| amounts[2] % 0.5 != 0) {
					if (amounts[2] < 0) {
						System.out.print("Invalid input. Enter a value >= 0: ");
						amounts[2] = sc.nextDouble();
					}
					else if (amounts[2] % 0.5 != 0) {
						System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
						amounts[2] = sc.nextDouble();
					}
				}
			}
		}
		if (names.length >= 4) {
			Random ranGen = new Random(100);		

			for (int i = 3; i < names.length; i++) {
				System.out.print("Enter the amount of " + ( "Cheese Type " + (char)('A' + i)) +" in lbs: ");
				amounts[i] = sc.nextDouble();

				if (amounts[i] < 0 || amounts[i] % 0.5 != 0) {
					while(amounts[i] < 0|| amounts[i] % 0.5 != 0) {
						if (amounts[i] < 0) {
							System.out.print("Invalid input. Enter a value >= 0: ");
							amounts[i] = sc.nextDouble();
						}
						else if (amounts[i] % 0.5 != 0) {
							System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
							amounts[i] = sc.nextDouble();
						}
					}
				}
			}
		}
	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	public static void itemizedList(String[] names, double[] prices, double[] amounts) {
		// Fill-in
		//stem.out.println("");
		if (amounts[0] == 0 && amounts[1] == 0 && amounts[2] == 0) {
			System.out.println("No tems were purchased.");
		}
		if (amounts[0] > 0) {
			if (amounts[0] > 0) {
				System.out.printf(amounts[0] + " lb of Humboldt Fog @ $25.00 = $%.2f",(amounts[0] * prices[0]));
				System.out.println("");
			}
		}

		if (amounts.length > 1) {
			if(amounts[1] > 0) {
				System.out.printf(amounts[1] + " lb of Red Hawk @ $40.50 = $%.2f",(amounts[1] * prices[1]));
				System.out.println("");
			}
		}
		if(amounts.length > 2) {
			if (amounts[2] > 0) {
				System.out.printf(amounts[2] + " lb of Teleme @ $17.25 = $%.2f",(amounts[2] * prices[2]));
				System.out.println("");
			}
		}
		for (int i = 3; i < names.length; i++) {
			if(amounts.length > 4) {
				if(amounts[i] > 0) {
					System.out.printf(amounts[i] + " lb of " + "Cheese type " + (char)('A' + i) +" @ $"+ prices[i] + " = $%.2f",(amounts[i] * prices[i]));
					System.out.println("");
				}
			}
		}
		System.out.println("");
	}



	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	public static double calcSubTotal(double[] prices, double[] amounts) {
		// Fix
		double total = (amounts[0] * prices[0]);

		if (amounts.length > 1) {
			total += (amounts[1] * prices[1]);
		}

		if (amounts.length > 2) {
			total += (amounts[2] * prices[2]);
		}

		if(amounts.length >= 4) {
			for (int i = 3; i < amounts.length; i++){
				total += (amounts[i] * prices[i]);
			}
		}
		return total;
	}
	/*
	 *  Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 *  stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 */
	public static double[] discountSpecials(double[] amounts, double[] prices){
		// Fix
		double[] disSpecials = new double[amounts.length];

		if (amounts[0] > 0.5) {
			disSpecials[0] = (((int)(amounts[0]) * (prices[0] / 2)));
		}

		/* 
		 * double the_num_pkg = (int)amount * 2
		 * double the_num_of_free_pkg = (int)the_num_pkg / 2
		 * double discount = (double)the_num_free_pkg * (price / 2)
		 */
		double the_num_pkg;
		double the_num_of_free_pkg;

		if (amounts.length > 1) {
			the_num_pkg = (int)amounts[1] * 1.5;
			the_num_of_free_pkg = (int)the_num_pkg / 2;
			disSpecials[1] = (double)the_num_of_free_pkg * (prices[1] / 2);
			System.out.printf("Red Hawk (Buy 2 Get 1 Free): \t -$%.2f",amounts[1]);
			System.out.println("");

		}
		return disSpecials;
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total.
	 */
	public static double printSubTotals(double subTotal, double[] disSpecials) {

		System.out.printf("Sub total: \t\t\t  $%.2f", subTotal);
		System.out.println("");
		System.out.println("Specials...");

		if (disSpecials[0] > 0) {
			System.out.printf("Humbodlt Fog (Buy 1 Get 1 Free): -$%.2f", disSpecials[0]);
			System.out.println("");
		}
		if (disSpecials.length > 1){
			System.out.printf("Red Hawk (Buy 2 Get 1 Free): \t -$%.2f",disSpecials[1]);
			System.out.println("");
		}



		double discount_total = (disSpecials[0]);
		if (disSpecials.length > 1) {
			discount_total += disSpecials[1];
		}
		if (discount_total == 0)
			System.out.println("None \t\t\t\t -$0.00");
		double newSub = subTotal - discount_total;
		System.out.printf("New Subtotal: \t\t\t  $%.2f", newSub);
		System.out.println("");


		return newSub;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total.
	 */
	public static void printFinalTotal(double newSubTotal) {
		// Fill-in
		double final_total = newSubTotal;

		if (final_total > 250) {
			System.out.print("Additional 25% discount: ");
			System.out.printf("\t -$%.2f",(final_total*.25));
			System.out.println("");
			final_total =  final_total - (final_total *.25);
		}
		else if (final_total > 150) {
			System.out.print("Additional 10% ");
			System.out.printf("discount: \t -$%.2f",(final_total*.10));
			System.out.println("");
			final_total =  final_total - (final_total / 10);
		}
		else {
			System.out.println("Additional 10% discount: \t -$0.00" );
		}


		System.out.printf("Final total: \t\t\t  $%.2f",final_total);
	}

	/*
	 * Program starts here
	 */
	public static void main(String[] args) {

		final int MAXCHEESE;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		MAXCHEESE = sc.nextInt();

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		intro(names, prices, amounts);

		getAmount(sc, names, amounts);

		double subTotal = calcSubTotal(prices, amounts);


		if (MAXCHEESE != 0 ) {
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int display = sc.nextInt();

			if (display == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));

		printFinalTotal(newSubTotal);

		sc.close();
	}
}