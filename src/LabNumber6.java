import java.util.Scanner;

public class LabNumber6 {
	
	public static void main(String[] args) {
		
		//Dice Rolling Simulator
		//Alex Nouhan
		//Grand Circus 2019
		
		//Type "s" at the roll again prompt to see how many special cases you've gotten!
		//Type "h" at the roll again prompt to see the help menu
		
		
		//import scanner, declare variables, and greet user
		Scanner scan = new Scanner(System.in);
		int sides;
		char userChar = 'y';
		int die1;
		int die2;
		int counter = 1;
		int s = 0;
		int b = 0;
		int c = 0;
		
		System.out.println("Welcome to Grand Circus Casino!");
		System.out.println("===============================");
		System.out.println();
		
		//Promt user and get input
		System.out.print("How many sides should each die have?: ");
		while (!scan.hasNextInt()) {
			scan.nextLine();
			System.out.println();
			System.out.print("Enter a positive integer: ");
		}
		sides = scan.nextInt();
		
		//main loop body
		do {
			System.out.println();
			//roll both dice
			die1 = Math.abs(generateRandomDieRoll(sides));
			die2 = Math.abs(generateRandomDieRoll(sides));
			System.out.println("Roll " + counter);
			
			System.out.println(die1);
			System.out.println(die2);
			
			
			//check for special cases
			if (die1 == 1 && die2 == 1) {
				System.out.println("*Snake Eyes!*");
				s += 1;
			}
			if (die1 == 6 && die2 == 6) {
				System.out.println("*Boxcar!*");
				b += 1;
			}
			if (die1 + die2 == 7 || die1 + die2 == 11) {//roll is equal to 7 or 11
				System.out.println("*Craps!*");
				c += 1;
			}
						
			//ask to continue
			System.out.println();
			System.out.print("Roll again? (y/n): ");
			do {
				userChar = scan.next().charAt(0);
				userChar = Character.toLowerCase(userChar);
				if (userChar == 's') {
					System.out.println("You've gotten " + s + " Snake Eyes, " + b + " Boxcars, " + c + " craps!");
				}
				
				if (userChar == 'h') {
					System.out.println("I'm sorry, there's nothing I can do...");
				}

				if (userChar != 'y' && userChar != 'n') {
					System.out.println();
					System.out.print("Please, try again! (y/n): ");
				}
			} while (userChar != 'y' && userChar != 'n');
			counter += 1;
		} while (userChar == 'y');
		
		System.out.println();
		System.out.println("Goodbye!");
		scan.close();
		
	}

	public static int generateRandomDieRoll(int sides) {
		int roll = (int)((Math.random() * sides) + 1);
		return roll;
	}
	
}
