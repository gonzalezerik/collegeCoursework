import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
public class CheeseShop {
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		int MAXCHEESE = 0;

		double humboldt = 25.00;
		double hawk = 40.50;
		double teleme = 17.25;
		double humboldt_lbs = 0;
		double hawk_lbs = 0;
		double teleme_lbs = 0;


		System.out.print("Enter the number of Cheeses for shop setup: ");
		MAXCHEESE = input.nextInt();
		double[] cheese_lbs = new double[MAXCHEESE];
		double[] cheese = new double[MAXCHEESE];

		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages): ");
		if (MAXCHEESE >= 1)
			System.out.println("Humboldt Fog: $25.00 per pound  ");
		if(MAXCHEESE >= 2)
			System.out.println("Red Hawk: $40.50 per pound"); 
		if (MAXCHEESE >= 3)
			System.out.println("Teleme: $17.25");

		if (MAXCHEESE >= 4) {
			Random ranGen = new Random(100);		

			for (int i = 3; i < MAXCHEESE; i++) {
				System.out.print("Cheese Type " + (char)('A' + i));
				cheese[i] = ranGen.nextInt(1000)/100.0;

				System.out.println(": $" + cheese[i] + " per pound");
			}
		}

		System.out.println("");

		if (MAXCHEESE >= 1) {
			System.out.print("Enter the amount of Humboldt Fog in lbs:  ");
			humboldt_lbs = input.nextDouble();
			while (humboldt_lbs < 0 || humboldt_lbs % 0.5 != 0) {
				if (humboldt_lbs < 0) {
					while (humboldt_lbs < 0 ) {
						System.out.print("Invalid input. Enter a value >= 0: ");
						humboldt_lbs = input.nextDouble();
					}
				}
				if (humboldt_lbs % 0.5 != 0) {
					while (humboldt_lbs % 0.5 > 0) {
						System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
						humboldt_lbs = input.nextDouble();
					}
				}
			}
		}

		if (MAXCHEESE >= 2) {
			System.out.print("Enter the amount of Red Hawk in lbs: ");
			hawk_lbs = input.nextDouble();

			while (hawk_lbs < 0 || hawk_lbs % 0.5 != 0) {
				if (hawk_lbs < 0) {
					while (hawk_lbs < 0 ) {
						System.out.print("Invalid input. Enter a value >= 0: ");
						hawk_lbs = input.nextDouble();
					}
				}
				if (hawk_lbs % 0.5 != 0) {
					while (hawk_lbs % 0.5 > 0) {
						System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
						hawk_lbs = input.nextDouble();
					}
				}
			}
		}

		if (MAXCHEESE >= 3) {
			System.out.print("Enter the amount of Teleme in lbs: ");
			teleme_lbs = input.nextDouble();

			if (teleme_lbs < 0 || teleme_lbs % 0.5 != 0) {
				while(teleme_lbs < 0|| teleme_lbs % 0.5 != 0) {
					if (teleme_lbs < 0) {
						System.out.print("Invalid input. Enter a value >= 0: ");
						teleme_lbs = input.nextDouble();
					}
					else if (teleme_lbs % 0.5 != 0) {
						System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
						teleme_lbs = input.nextDouble();
					}
				}
			}
		}
		if (MAXCHEESE >= 4) {
			Random ranGen = new Random(100);		

			for (int i = 3; i < MAXCHEESE; i++) {
				System.out.print("Enter the amount of " + ( "Cheese Type " + (char)('A' + i)) +" in lbs: ");
				cheese_lbs[i] = input.nextDouble();

				if (cheese_lbs[i] < 0 || cheese_lbs[i] % 0.5 != 0) {
					while(cheese_lbs[i] < 0|| cheese_lbs[i] % 0.5 != 0) {
						if (cheese_lbs[i] < 0) {
							System.out.print("Invalid input. Enter a value >= 0: ");
							cheese_lbs[i] = input.nextDouble();
						}
						else if (cheese_lbs[i] % 0.5 != 0) {
							System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
							cheese_lbs[i] = input.nextDouble();
						}
					}
				}
			}
		}

		int list_check = 0;

		if (MAXCHEESE == 0) {
			System.out.println("");
		}
		else {
			System.out.println("");
			System.out.print("Display the itemized list? (1 for yes) ");
			list_check = input.nextInt();
			if (list_check == 1) {
				if (humboldt_lbs == 0 && hawk_lbs == 0 && hawk_lbs == 0) {
					System.out.println("No tems were purchased.");
				}
				if (humboldt_lbs > 0) {
					System.out.printf(humboldt_lbs + " lb of Humboldt Fog @ $25.00 = $%.2f",(humboldt_lbs * humboldt));
					System.out.println("");
					//System.out.println(humboldt_lbs + " lb of Humboldt Fog @ $25.0 = $" + (humboldt_lbs * humboldt);

					if (hawk_lbs > 0) {
						System.out.printf(hawk_lbs + " lb of Red Hawk @ $40.50 = $%.2f",(hawk_lbs * hawk));
						System.out.println("");
					}
					if(teleme_lbs > 0) {
						System.out.printf(teleme_lbs + " lb of Teleme @ $17.25 = $%.2f",(teleme_lbs * teleme));
						System.out.println("");
					}
					for (int i = 3; i < MAXCHEESE; i++) {
						if(cheese_lbs[i] > 0) {
							System.out.printf(cheese_lbs[i] + " lb of " + "Cheese type " + (char)('A' + i) +" @ $"+ cheese[i] + " = $%.2f",(cheese_lbs[i] * cheese[i]));
							System.out.println("");
						}
					}

				}
				System.out.println("");
			} 
		
			else {
				System.out.println("");
			}
		}


			double total = ((humboldt_lbs * humboldt) + (hawk_lbs * hawk) + (teleme_lbs * teleme));

			if(MAXCHEESE >= 4) {
				for (int i = 3; i < MAXCHEESE; i++){
					total += (cheese_lbs[i] * cheese[i]);
				}
			}

			
			System.out.printf("Sub total: \t\t\t  $%.2f",total);
			System.out.println("");
			System.out.println("Specials...");

			double humboldt_discount = 0;
			double hawk_discount = 0;
			double teleme_discount = 0;


			if (humboldt_lbs > 0.5) {
				humboldt_discount = (((int)(humboldt_lbs) * (humboldt / 2)));
				System.out.printf("Humbodlt Fog (Buy 1 Get 1 Free): -$%.2f", humboldt_discount);
				System.out.println("");

			}

			/* 
			 * double the_num_pkg = (int)amount * 2
			 * double the_num_of_free_pkg = (int)the_num_pkg / 2
			 * double discount = (double)the_num_free_pkg * (price / 2)
			 */
			double the_num_pkg;
			double the_num_of_free_pkg;

			if (hawk_lbs > 1) {
				the_num_pkg = (int)hawk_lbs * 1.5;
				the_num_of_free_pkg = (int)the_num_pkg / 2;
				hawk_discount = (double)the_num_of_free_pkg * (hawk / 2);
				System.out.printf("Red Hawk (Buy 2 Get 1 Free): \t -$%.2f",hawk_discount);
				System.out.println("");

			}

			double discount_total = ((humboldt_discount + hawk_discount));
			if (discount_total == 0)
				System.out.println("None \t\t\t\t -$0.00");
			double newSub = total - discount_total;
			System.out.printf("New Subtotal: \t\t\t  $%.2f", newSub);
			System.out.println("");



			double final_total = total - discount_total;

			if (final_total > 150) {
				System.out.print("Additional 10% ");
				System.out.printf("discount: \t -$%.2f",(final_total*.10));
				System.out.println("");
				final_total =  final_total - (final_total / 10);
			}
			else {
				System.out.println("Additional 10% discount: \t -$0.00" );
			}
			if (final_total > 250) {
				System.out.print("Additional 15% discount: ");
				System.out.printf("\t -$%.2f",(final_total*.15));
				System.out.println("");
				final_total =  final_total - (final_total / 15);
			}
			
			System.out.printf("Final total: \t\t\t  $%.2f",final_total);

		}
	}
