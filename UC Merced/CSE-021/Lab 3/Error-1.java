import java.util.Random;

public class Error {

	public static void main(String[] args) {

		final int MAXCHEESE = 10;

		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		// Three Special Cheeses
		if (MAXCHEESE > 0 & MAXCHEESE <= 20) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
		}
		if (MAXCHEESE > 1) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
		}
		if (MAXCHEESE > 2) {
			names[2] = "Teleme";
			prices[2] = 17.25;
		}
		if (MAXCHEESE > 20) {
			System.out.println("Too much cheese");
		}
		else {
			System.out.println("We sell " + MAXCHEESE + " kinds of Cheese:");
			if (MAXCHEESE > 0 && MAXCHEESE <= 20)
				System.out.println(names[0] + ": $" + prices[0] + " per pound");
			if (MAXCHEESE > 1)
				System.out.println(names[1] + ": $" + prices[1] + " per pound");
			if (MAXCHEESE > 2)
				System.out.println(names[2] + ": $" + prices[2] + " per pound");

			Random ranGen = new Random(100);

			for (int i = 3; i < MAXCHEESE; i++) {
				names[i] = "Cheese Type " + (char)('A' + i);
				prices[i] = ranGen.nextInt(1000)/100.0;
				amounts[i] = 0;

				System.out.println(names[i] + ": $" + prices[i] + " per pound");
			}
			System.out.println("Cheese " + 'A' + 10); System.out.println("Cheese " + (char)'A' + 10); System.out.println("Cheese " + (int)'A' + 10); System.out.println("Cheese " + (char)('A' + 10)); System.out.println("Cheese " + (int)('A' + 10)); 

		}
	}
}
