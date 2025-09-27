import java.util.*;

public class ShopArr {

	// Instance Variables
	private Cheese[] cheese;
	
	// Initialize method
	private void init(int max) {
		
		// Create max number of Cheese pointers
		cheese = new Cheese[max]; 
		
		if (max > 0) {
			cheese[0] = new Cheese();
			cheese[0].setName("Humboldt Fog");
			cheese[0].setPrice(25.00);
			
			if (max > 1) {
				cheese[1] = new Cheese("Red Hawk");
				cheese[1].setPrice(40.50);
			
				if (max > 2) {
					cheese[2] = new Cheese("Teleme", 17.25);
					//cheese[2].setName("Wrong Name");
				}
			}
		}
		
		Random ranGen = new Random(100);

		for (int i = 3; i < max; i++) {
			// Fill-in Code
		}
		
	}
	public ShopArr() {
		init(10);
	}
	
	public ShopArr(int max) {
		init(max);
	}

	/*
	 * Displays the intro message informing the user of various cheeses sold and
	 * Gets the amount of each cheese the user would like to purchase. 
	 */
	private void intro(Scanner input) {
		Random ranGen = new Random(100);
		System.out.println("We sell " + cheese.length + " kinds of Cheese (in 0.5 lb packages)");
		
		if (cheese.length > 0 )
			System.out.println( cheese[0].getName() + ": $ " + cheese[0].getPrice() + " per pound");
		if (cheese.length > 1 )
			System.out.println( cheese[1].getName() + ": $ " + cheese[1].getPrice() + " per pound");
		if (cheese.length > 2 )
			System.out.println( cheese[2].getName() + ": $ " + cheese[2].getPrice() + " per pound");
		
		for (int i = 3; i < cheese.length; i++) {
		cheese [i] = new Cheese();
		cheese [i].setName("Cheese Type " +(char)('A' + i));
		cheese [i].setPrice(ranGen.nextInt(1000)/100.0);

		System.out.println(cheese[i].getName() + ": $ " + cheese[i].getPrice()  +  " per pound");
		}
		
		for (int i = 0; i < cheese.length; i ++) {
			System.out.print("Enter the amount of " + cheese[i].getName() + " : ");
			cheese[i].setAmount(input.nextInt());
			
			
		}
		// Fill-in Code
	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	private void itemizedList(){
		double amt = 0, price = 0;
		// Fill-in Code
		if ((cheese[0].getAmount() + cheese[1].getAmount() + cheese[2].getAmount()) == 0)
			System.out.println("No items were purchased.");
		else {
			if ((amt = cheese[0].getAmount()) > 0) {
				price = cheese[0].getPrice();
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amt, cheese[0].getName(), price, price*amt);
			}
			// Fill-in Code
			
			if((amt = cheese[1].getAmount()) > 0) {
				System.out.println(amt + " lbs of Red Hawk  @ $45.50  = " + (amt * cheese[1].getPrice()));
			}
			
			
			if ((amt = cheese[2].getAmount()) > 0) {
				System.out.println(amt + " lbs of Teleme  @ $17.25  = " + (amt * cheese[2].getPrice()));
			}
		}
		System.out.print("\n");
	}

	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	private double calcSubTotal() {
		double subTotal = 0;
		// Fill-in Code
		
		int amt;
		System.out.println();
		// Fill-in Code
		System.out.println();
		
		for (int i = 0; i < cheese.length;i++) {
			if (cheese[i].getAmount() > 0) {
			System.out.println(cheese[i].getAmount() + " lbs of " + (cheese[i].getName() + " @ " + (cheese[i].getPrice() + " =  $ " + (cheese[i].getAmount() * cheese[i].getPrice() ))) );	
				
			}
			
			
		}

		return subTotal;
	}

	/*
	 * Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 * stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 * Minor changes from Lab 07 (identical logic). 
	 */
	private double[] discountSpecials() {
		double[] disSpecials = {0, 0};
		
		double hfAmt = 0, rhAmt = 0;
		
		if (hfAmt > 0) {
			// Fill-in Code
			disSpecials[0] += (((int) hfAmt * cheese[0].getPrice())/ 2.0);
		}
		
		if(rhAmt > 0) {
			// Fill-in Code	
			disSpecials[0] += ((int) (rhAmt / 1.5) * cheese[1].getPrice() * 0.5);
		}
		
		return disSpecials;		
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total. Identical to Lab 07.
	 */
	private double printSubTotals(double subTotal, double[] disSpecials) {
		// Fix code
		System.out.println("Original Sub Total:\t\t      $" + subTotal);
		System.out.println("Specials...");
		if(subTotal ==0) {
			System.out.println("None:\t\t\t\t\t-$0.0");
		}
		if(disSpecials.length > 1 && disSpecials[0] > 0) {
			System.out.print("Humboldt Fog (Buy one get one free): -$");
			System.out.printf("%.2f", disSpecials[0]);
			System.out.print("\n");
			
		}
		if(disSpecials.length > 1 && disSpecials[1] > 0) {
			System.out.println("Red Hawk (Buy two get one free): ");
			System.out.printf("%.2f", disSpecials[1]);
			System.out.print("\n");
		}
		double newSub = subTotal;
		for (int i = 0; i < disSpecials.length; i++) {
			newSub -= disSpecials[i];
		}
		
		
		return newSub;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total. Identical to Lab 07.
	 */
	private void printFinalTotal(double newSubTotal) {
		// Fill-in code
		System.out.printf("NewSub Total\t\t\t      $%.2f", newSubTotal);
		System.out.print("\n");
		double count = 0;
		
		if (newSubTotal >= 150) {
			count = (newSubTotal * 0.10);
		}
		if (newSubTotal >= 250) {
			count = (newSubTotal * 0.25);
		}
		if (newSubTotal < 150) {
			count = (newSubTotal * 0);
		}
		
		if (newSubTotal > 0) {
			System.out.print("Additional 10% Discount:\t     -$");
			System.out.printf("%.2f", count);
			System.out.print("\n");
		}
		if (newSubTotal == 0) {
			System.out.print("Additional 0% Discount:\\t     -$");
			System.out.printf("%.2f", count);
			System.out.print("\n");
			
		}
		double finalTotal = newSubTotal - count;
		System.out.printf("Final Total: \t\t\t      $%.2f",finalTotal);
		System.out.print("\n");
		
	}

	private void printFree(){
		double amt;
		System.out.println();
		System.out.println("Today is your lucky day!");
		for (int i = 0; i < cheese.length; i++) 		
			if ((amt = cheese[i].getAmount()) > 0)
				System.out.println(amt + " lb of " + cheese[i].getName() + " @ $0 = $" + 0);
		System.out.println("Total Price: FREE!!!\n");
	}

	public void run() {

		Scanner input = new Scanner(System.in);
		intro(input);
		double subTotal = calcSubTotal();
		
		System.out.println();
		System.out.print("Display the itemized list? (1 for yes): ");
		int list = input.nextInt();
		if (list == 1)
			itemizedList();	

		int free = (new Random()).nextInt(100);
		//System.out.println("Random num is " + free);
		if (free != 0) {
			double newSubTotal = printSubTotals(subTotal, discountSpecials());
			printFinalTotal(newSubTotal);
		} else {
			printFree();
			return;
		}
		
		System.out.println();
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();

		System.out.println();

		if (redo == 1)
			run();
		else
			System.out.println("Thanks for coming!");
	}
}
