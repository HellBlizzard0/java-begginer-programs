import java.util.Scanner;
import java.util.InputMismatchException;

public class DateToFloatYear {

	public static void main(String[] args) {
		
		boolean loop = true;	//Remains true until we reach the full execution of the program
		Scanner k = new Scanner(System.in);
		printStartUpMessage();
		do {
			try {
				//Prompt and read the day, month, and year
				System.out.print( "Enter day, month, year:  ");	
				int day = k.nextInt(), month = k.nextInt(), year = k.nextInt();
				
				//Validity checker
				if (checkInputValidity( day, month, year)) {
					
					int daysInDecimal = getDaysInDecimal(day, month, year);
					
					System.out.printf("The decimal date is: %f", getFullDateInDecimal( daysInDecimal , year));
					loop = false;
				}
				else {
					System.out.println("Error: The date is invalid\n");
					continue;
				}
			}	
			catch (InputMismatchException e) {
				System.out.println("Error: "+ e + "\n");
				k.nextLine();
			 }
		} while (loop);

	}
	
	private static double getFullDateInDecimal(int daysInDecimal, int year) {
		
		//Leap-year checker
		if ( year % 400 == 0 || year % 4 == 0 && year % 4 != 0) 
			return year + ( daysInDecimal - 1) / 366.0;
		else
			return year + ( daysInDecimal - 1) / 365.0;
	}
	private static int getDaysInDecimal(int day, int month, int year) {
		
		int daysum = 0, daymax = 0;
		
		// Adds the number of days in the last month specified, aka the user input day
		daysum+=day;
		month--;
		
		// Loop to add the days of the year until the specified day. Sums the months' days in a descending manner
		while ( month > 0 ) {
			// Nested if to set the daymax
			if ( month == 2) {	
				
				// Leap-year checker
				if ( year % 400 == 0 || year % 4 == 0 && year % 4 != 0) { 
					// Then Feb has 29 days
					daymax = 29;
					daysum += daymax;
				}
				else {
					// Then Feb has 28 days
					daymax = 28;
					daysum += daymax;
				}
			}
			else if ( month == 4 || month == 6 || month == 9 || month == 11) {
				// Then the month has 30 days
				daymax = 30;
				daysum += daymax;
				}
			else {
				// Then the month has 31 days
				daymax = 31;
				daysum += daymax;
			}
			month--;
			
		}
		return daysum;
	}
	private static boolean checkInputValidity(int day, int month, int year) {	
		int daymax;
		// Year input interval validity checker
		if ( year >= 4000 || year <= 1900) {
			return false;
		}
		// Nested if to check the daymax
		if ( month == 2) {	// For Feb only
			//Leap-year checker
			if ( year % 400 == 0 || year % 4 == 0 && year % 4 != 0) 
				// Then Feb has 29 days
				daymax = 29;
			else
				// Then Feb has 28 days
				daymax = 28;
		}
		else if ( month == 4 || month == 6 || month == 9 || month == 11)
			// Then the month has 30 days
			daymax = 30;
		else 
			// Then the month has 31 days
			daymax = 31;
		// If the input days are larger than the maximum days in the particular month
		if ( day > daymax )
			return false;
		else 
			return true;
	}
	private static void printStartUpMessage () {
		// Start-up message
		System.out.println("The program computes and displays the decimal date of a date input as: day month year.\n\n");
	}
}
