import java.util.Scanner;
public class CheeseShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
		System.out.println("Humboldt Fog: $25.00 per pound  ");
		System.out.println("Red Hawk: $40.50 per pound");
		System.out.println("Teleme: $17.25");
		
	
		double humboldt = 25;
		double hawk = 40.50;
		double teleme = 17.25;
		double humboldt_lbs;
		double hawk_lbs;
		double teleme_lbs;
		
		System.out.println("");
				
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
		
		System.out.print("Enter the amount of Teleme in lbs: ");
		teleme_lbs = input.nextDouble();
		
		while (teleme_lbs < 0 || teleme_lbs % 0.5 != 0) {
			if (teleme_lbs < 0) {
				while (teleme_lbs < 0 ) {
					System.out.print("Invalid input. Enter a value >= 0: ");
					teleme_lbs = input.nextDouble();
				}
			}
			if (teleme_lbs % 0.5 != 0) {
				while (teleme_lbs % 0.5 > 0) {
					System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
					teleme_lbs = input.nextDouble();
				}
			}
		}
		System.out.println("");
		
		int list_check;
		System.out.print("Display the itemized list? (1 for yes) ");
		list_check = input.nextInt();
		
		if (list_check == 1) {
			if (humboldt_lbs == 0 && hawk_lbs == 0 && teleme_lbs == 0) {
				System.out.println("No tems were purchased.");
			}
			if (humboldt_lbs > 0)
				System.out.println(humboldt_lbs + " lb of Humboldt Fog @ $25.0 = $" + (humboldt_lbs * humboldt));
				
			if (hawk_lbs > 0)
				System.out.println(hawk_lbs + " lb of Red Hawk @ $40.50 = $" + (hawk_lbs * hawk));
			
			if(teleme_lbs > 0)
				System.out.println(teleme_lbs + " lb of Teleme @ $17.25 = $" + (teleme_lbs * teleme));
		}
		else {
			
		}
		
		double total = ((humboldt_lbs * humboldt) + (hawk_lbs * hawk) + (teleme_lbs * teleme));
		
		System.out.println("");
		System.out.println("Sub total: \t\t\t  $" + total);
		System.out.println("Discounts...");
		
		double humboldt_discount = 0;
		double hawk_discount = 0;
		double teleme_discount = 0;
		
		if (humboldt_lbs > 0.5) {
			humboldt_discount = ((humboldt_lbs * (humboldt / 2)));
			System.out.println("Humbodlt Fog (Buy 1 Get 1 Free): -$" + humboldt_discount);
			
		}
	
		if (hawk_lbs > 1) {
			hawk_discount = ((hawk_lbs * (hawk / 4)));
			System.out.println("Humbodlt Fog (Buy 2 Get 1 Free): -$" + hawk_discount);
			
		}
		
		double discount_total = (humboldt_discount + hawk_discount + teleme_discount);
		if (discount_total == 0)
			System.out.println("None \t\t\t\t -$0.0");
			
		
		double final_total = total - discount_total;
		
		System.out.println("Final Total: \t\t\t  $" + final_total);
	}
}
