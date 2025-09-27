import java.util.Scanner;

public class Cheese {

	private String name;
	private double price;
	private double amount;

	public static int numCheese = 0;
	
	public Cheese() { // Constructor with no parameters
		name = "";
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name) { // Constructor with name as paramter
		this.name = name;
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name, double price) { // Constructor with 2 parameters
		// Fill-in Code
	}

	public String getName() { // Accessor
		return name;
	}

	public void setName(String newName) { // Mutator 
		name = newName;
	}

	public double getPrice() {
		// Fix Code
		return 0;
	}

	public void setPrice(double newPrice) {
		// Fill-in Code
	}

	public double getAmount() {
		// Fix Code
		return 0;
	}

	public void setAmount(Scanner input) {
		// Fill-in Code
	}

}
