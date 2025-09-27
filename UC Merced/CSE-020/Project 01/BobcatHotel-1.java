import java.util.Scanner;
import java.util.Random;

public class BobcatHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final double single = 50.50;
		final double Double = 75.00;
		final double queen = 100.75;
		final double king = 150.25;
		final double master = 225.50;

		double roomCost, mealCost, pTotalCost = 0, aDiscount = 0, clubDiscount = 0, totalCost, mealChoice = 0;

		int guests, roomChoice, nights, meal, randNum = 0, count = 0, nights2 = 0, discounts = 0;
		int AAA, club;
		boolean bL1, bL2;

		Scanner kbd = new Scanner(System.in);

		System.out.println("ROOM OPTIONS");
		System.out.println("1. Single: $50.50 per night");
		System.out.println("2. Double: $75.00 per night");
		System.out.println("3. Queen: $100.75 per night");
		System.out.println("4. King: $150.25 per night");
		System.out.println("5. Master Suite: $225.50 per night");

		System.out.print("\nNumber of guests: ");
		guests = kbd.nextInt();

		System.out.print("Please enter your choice of room (enter 1/2/3/4/5 corresponding to the options shown above): ");
		roomChoice = kbd.nextInt();

		switch(roomChoice) {

		case 1:

			System.out.print("Please enter the number of nights: ");
			nights = kbd.nextInt();

			System.out.print("Are you a AAA member (enter 1 for yes, 0 for no)? ");
			AAA = kbd.nextInt();

			if (AAA == 1)
				bL1 = true;
			else
				bL1 = false;

			System.out.print("Are you a club member (enter 1 for yes, 0 for no)? ");
			club = kbd.nextInt();


			if (club == 1) {
				bL2 = true;
				Random ran = new Random();
				randNum = ran.nextInt(11) + 0;

				if (randNum >= 4) {
					System.out.print("\nCongratulations! You've qualified for our \"Stay 4 nights get 1 free promotion\"");
					System.out.println("\nDiscount will be applied during checkout depending on the number of days");
				}
				else 
					System.out.println("\nUnfortuantly, you didn't qualify for our \"Stay 4 nights get 1 free promotion\". Better luck next time! ");

			}
			else 
				bL2 = false;

			System.out.println("\nMEAL PACKAGES (PRICES SHOWN ARE PER NIGHT)");
			System.out.println("0. Complementary @ $0 per guest");
			System.out.println("1. Standard @ $30 per guest");
			System.out.println("2. Deluxe @ $50 per guest");

			System.out.print("\nPlease select your desired meal package (enter 0/1/2 corresponding to the options shown above): ");
			meal = kbd.nextInt();

			if (meal == 0)
				mealChoice = 0;
			if (meal == 1)
				mealChoice = 30;
			if (meal == 2)
				mealChoice = 50;



			System.out.println("\nCHECKOUT");

			roomCost = (double) (nights * single);
			System.out.println("Room Cost: \t\t\t$" + roomCost);

			mealCost = (double)(guests * nights * mealChoice);
			if (meal != 0) {
				System.out.println("Meal Cost: \t\t\t" + "+$" + mealCost);
			}

			pTotalCost = roomCost + mealCost; 
			System.out.println("Preliminary Total Cost: \t$" + pTotalCost);

			if (bL1 == true) {
				aDiscount = (double)pTotalCost * 0.10;
				System.out.println("AAA Discount: \t\t\t" + "-$" + aDiscount);
			}

			if (bL2 == true) {

				if (randNum >= 4) {

					discounts = nights / 4;

					clubDiscount = (double) discounts * single;
					System.out.println("Club Memeber Discount: \t\t" + "-$" + clubDiscount);
				}
			}

			if (bL1 == false && bL2 == false || bL1 == false && randNum < 4)
				System.out.println("No Disounts Applied");

			totalCost = pTotalCost - (aDiscount + clubDiscount);
			System.out.println("Total Cost of booking: \t\t$" + totalCost);
			break;
		case 2:

			System.out.print("Please enter the number of nights: ");
			nights = kbd.nextInt();

			System.out.print("Are you a AAA member (enter 1 for yes, 0 for no)? ");
			AAA = kbd.nextInt();

			if (AAA == 1)
				bL1 = true;
			else
				bL1 = false;

			System.out.print("Are you a club member (enter 1 for yes, 0 for no)? ");
			club = kbd.nextInt();


			if (club == 1) {
				bL2 = true;
				Random ran = new Random();
				randNum = ran.nextInt(11) + 0;

				if (randNum >= 4) {
					System.out.print("\nCongratulations! You've qualified for our \"Stay 4 nights get 1 free promotion\"");
					System.out.println("\nDiscount will be applied during checkout depending on the number of days");
				}
				else 
					System.out.println("\nUnfortuantly, you didn't qualify for our \"Stay 4 nights get 1 free promotion\". Better luck next time! ");

			}
			else 
				bL2 = false;

			System.out.println("\nMEAL PACKAGES (PRICES SHOWN ARE PER NIGHT)");
			System.out.println("0. Complementary @ $0 per guest");
			System.out.println("1. Standard @ $30 per guest");
			System.out.println("2. Deluxe @ $50 per guest");


			System.out.print("\nPlease select your desired meal package (enter 0/1/2 corresponding to the options shown above): ");
			meal = kbd.nextInt();

			if (meal == 0)
				mealChoice = 0;
			if (meal == 1)
				mealChoice = 30;
			if (meal == 2)
				mealChoice = 50;



			System.out.println("\nCHECKOUT");

			roomCost = (double) (nights * Double);
			System.out.println("Room Cost: \t\t\t$" + roomCost);

			mealCost = (double)(guests * nights * mealChoice);
			if (meal != 0) {
				System.out.println("Meal Cost: \t\t\t" + "+$" + mealCost);
			}

			pTotalCost = roomCost + mealCost; 
			System.out.println("Preliminary Total Cost: \t$" + pTotalCost);

			if (bL1 == true) {
				aDiscount = (double)pTotalCost * 0.10;
				System.out.println("AAA Discount: \t\t\t" + "-$" + aDiscount);
			}

			if (bL2 == true) {

				if (randNum >= 4) {

					discounts = nights / 4;

					clubDiscount = (double) discounts * Double;
					System.out.println("Club Memeber Discount: \t\t" + "-$" + clubDiscount);
				}
			}

			if (bL1 == false && bL2 == false || bL1 == false && randNum < 4)
				System.out.println("No Disounts Applied");

			totalCost = pTotalCost - (aDiscount + clubDiscount);
			System.out.println("Total Cost of booking: \t\t$" + totalCost);
			break;

		case 3:

			System.out.print("Please enter the number of nights: ");
			nights = kbd.nextInt();

			System.out.print("Are you a AAA member (enter 1 for yes, 0 for no)? ");
			AAA = kbd.nextInt();

			if (AAA == 1)
				bL1 = true;
			else
				bL1 = false;

			System.out.print("Are you a club member (enter 1 for yes, 0 for no)? ");
			club = kbd.nextInt();


			if (club == 1) {
				bL2 = true;
				Random ran = new Random();
				randNum = ran.nextInt(11) + 0;

				if (randNum >= 4) {
					System.out.print("\nCongratulations! You've qualified for our \"Stay 4 nights get 1 free promotion\"");
					System.out.println("\nDiscount will be applied during checkout depending on the number of days");
				}
				else 
					System.out.println("\nUnfortuantly, you didn't qualify for our \"Stay 4 nights get 1 free promotion\". Better luck next time! ");

			}
			else 
				bL2 = false;	

			System.out.println("\nMEAL PACKAGES (PRICES SHOWN ARE PER NIGHT)");
			System.out.println("0. Complementary @ $0 per guest");
			System.out.println("1. Standard @ $30 per guest");
			System.out.println("2. Deluxe @ $50 per guest");


			System.out.print("\nPlease select your desired meal package (enter 0/1/2 corresponding to the options shown above): ");
			meal = kbd.nextInt();

			if (meal == 0)
				mealChoice = 0;
			if (meal == 1)
				mealChoice = 30;
			if (meal == 2)
				mealChoice = 50;

			System.out.println("\nCHECKOUT");

			roomCost = (double) (nights * queen);
			System.out.println("Room Cost: \t\t\t$" + roomCost);

			mealCost = (double)(guests * nights * mealChoice);
			if (meal != 0) {
				System.out.println("Meal Cost: \t\t\t" + "+$" + mealCost);
			}

			pTotalCost = roomCost + mealCost; 
			System.out.println("Preliminary Total Cost: \t$" + pTotalCost);

			if (bL1 == true) {
				aDiscount = (double)pTotalCost * 0.10;
				System.out.println("AAA Discount: \t\t\t" + "-$" + aDiscount);
			}

			if (bL2 == true) {

				if (randNum >= 4) {

					discounts = nights / 4;

					clubDiscount = (double) discounts * queen;
					System.out.println("Club Memeber Discount: \t\t" + "-$" + clubDiscount);
				}
			}

			if (bL1 == false && bL2 == false || bL1 == false && randNum < 4)
				System.out.println("No Disounts Applied");

			totalCost = pTotalCost - (aDiscount + clubDiscount);
			System.out.println("Total Cost of booking: \t\t$" + totalCost);
			break;

		case 4:


			System.out.print("Please enter the number of nights: ");
			nights = kbd.nextInt();

			System.out.print("Are you a AAA member (enter 1 for yes, 0 for no)? ");
			AAA = kbd.nextInt();

			if (AAA == 1)
				bL1 = true;
			else
				bL1 = false;

			System.out.print("Are you a club member (enter 1 for yes, 0 for no)? ");
			club = kbd.nextInt();

			if (club == 1) {
				bL2 = true;
				Random ran = new Random();
				randNum = ran.nextInt(11) + 0;

				if (randNum >= 4) {
					System.out.print("\nCongratulations! You've qualified for our \"Stay 4 nights get 1 free promotion\"");
					System.out.println("\nDiscount will be applied during checkout depending on the number of days");
				}
				else 
					System.out.println("\nUnfortuantly, you didn't qualify for our \"Stay 4 nights get 1 free promotion\". Better luck next time! ");

			}
			else 
				bL2 = false;

			System.out.println("\nMEAL PACKAGES (PRICES SHOWN ARE PER NIGHT)");
			System.out.println("0. Complementary @ $0 per guest");
			System.out.println("1. Standard @ $30 per guest");
			System.out.println("2. Deluxe @ $50 per guest");


			System.out.print("\nPlease select your desired meal package (enter 0/1/2 corresponding to the options shown above): ");
			meal = kbd.nextInt();

			if (meal == 0)
				mealChoice = 0;
			if (meal == 1)
				mealChoice = 30;
			if (meal == 2)
				mealChoice = 50;

			System.out.println("\nCHECKOUT");

			roomCost = (double) (nights * king);
			System.out.println("Room Cost: \t\t\t$" + roomCost);

			mealCost = (double)(guests * nights * mealChoice);
			if (meal != 0) {
				System.out.println("Meal Cost: \t\t\t" + "+$" + mealCost);
			}

			pTotalCost = roomCost + mealCost; 
			System.out.println("Preliminary Total Cost: \t$" + pTotalCost);

			if (bL1 == true) {
				aDiscount = (double)pTotalCost * 0.10;
				System.out.println("AAA Discount: \t\t\t" + "-$" + aDiscount);
			}

			if (bL2 == true) {

				if (randNum >= 4) {

					discounts = nights / 4;

					clubDiscount = (double) discounts * king;
					System.out.println("Club Memeber Discount: \t\t" + "-$" + clubDiscount);
				}
			}

			if (bL1 == false && bL2 == false || bL1 == false && randNum < 4)
				System.out.println("No Disounts Applied");

			totalCost = pTotalCost - (aDiscount + clubDiscount);
			System.out.println("Total Cost of booking: \t\t$" + totalCost);
			break;

		case 5:

			System.out.print("Please enter the number of nights: ");
			nights = kbd.nextInt();

			System.out.print("Are you a AAA member (enter 1 for yes, 0 for no)? ");
			AAA = kbd.nextInt();

			if (AAA == 1)
				bL1 = true;
			else
				bL1 = false;

			System.out.print("Are you a club member (enter 1 for yes, 0 for no)? ");
			club = kbd.nextInt();


			if (club == 1) {
				bL2 = true;
				Random ran = new Random();
				randNum = ran.nextInt(11) + 0;

				if (randNum >= 4) {
					System.out.print("\nCongratulations! You've qualified for our \"Stay 4 nights get 1 free promotion\"");
					System.out.println("\nDiscount will be applied during checkout depending on the number of days");
				}
				else 
					System.out.println("\nUnfortuantly, you didn't qualify for our \"Stay 4 nights get 1 free promotion\". Better luck next time! ");

			}
			else 
				bL2 = false;

			System.out.println("\nMEAL PACKAGES (PRICES SHOWN ARE PER NIGHT)");
			System.out.println("0. Complementary @ $0 per guest");
			System.out.println("1. Standard @ $30 per guest");
			System.out.println("2. Deluxe @ $50 per guest");
			System.out.println("3. Indulgence @ $85 per guest");

			System.out.print("\nPlease select your desired meal package (enter 0/1/2/3 corresponding to the options shown above): ");
			meal = kbd.nextInt();

			if (meal == 0)
				mealChoice = 0;
			if (meal == 1)
				mealChoice = 30;
			if (meal == 2)
				mealChoice = 50;
			if (meal == 3)
				mealChoice = 85;


			System.out.println("\nCHECKOUT");

			roomCost = (double) (nights * master);
			System.out.println("Room Cost:\t\t\t$" + roomCost);

			mealCost = (double)(guests * nights * mealChoice);
			if (meal != 0) {
				System.out.println("Meal Cost: \t\t\t" + "+$" + mealCost);
			}

			pTotalCost = roomCost + mealCost; 
			System.out.println("Preliminary Total Cost: \t$" + pTotalCost);

			if (bL1 == true) {
				aDiscount = (double)pTotalCost * 0.10;
				System.out.println("AAA Discount:\t\t\t" + "-$" + aDiscount);
			}

			if (bL2 == true) {

				if (randNum >= 4) {

					discounts = nights / 4;

					clubDiscount = (double) discounts * master;
					System.out.println("Club Memeber Discount:\t\t" + "-$" + clubDiscount);
				}
			}

			if (bL1 == false && bL2 == false || bL1 == false && randNum < 4)
				System.out.println("No Disounts Applied");

			totalCost = pTotalCost - (aDiscount + clubDiscount);
			System.out.println("Total Cost of booking:\t\t$" + totalCost);
			break;
		}
	}
}


