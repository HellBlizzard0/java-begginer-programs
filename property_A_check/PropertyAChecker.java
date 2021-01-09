import java.util.Scanner;
import java.lang.IllegalArgumentException;
import java.util.InputMismatchException;
public class PropertyAChecker {

	public static void main(String[] args) {
		
		boolean loop = true;	// Remains true until we reach the full execution of the program
		Scanner k = new Scanner(System.in);
			
		do {
			System.out.print( "Input a positive integer number to test it satisfies property A: ");
			try {
				// inNumber is the user input number || inCopy is a copy for inNumber to test the property A || dignum is to count how many digits inNumber have
				int inNumber = k.nextInt();
					
									
					// Property A satisfaction if statement
					if ( propertyA(inNumber) ) {
						System.out.println("The number " + inNumber + " satisfies property A.");
					}
					
					else {
						System.out.println("The number " + inNumber + " does not satisfy");
					}
					
					// Disables the do-while loop
					loop = false;
			}	
			catch (InputMismatchException e) {
				System.out.println("Error: "+ e);
				
			 }
			catch (IllegalArgumentException e) {
				System.out.println(e + ": parameter less than 1");
			}
		
		} while (loop);
	}
	private static boolean propertyA (int inNumber) throws IllegalArgumentException  {
	
		// Input validity checker
		if ( inNumber  < 0 ) 
			throw new IllegalArgumentException();

		
		int  inCopy = inNumber, dignum = 0, sum=0;
		// Digits counter for the inCopy
		while ( inCopy > 0 ) {
				
			inCopy/=10;
			dignum++;
		}		
			// Resets the inCopy to be = inNnumber
			inCopy=inNumber;
					
			//	Sums each digit of the input number to the power of number of digits
			for ( int i = 0; i < dignum; i++) {
				sum += Math.pow(inCopy%10, dignum);
				inCopy/=10;
			}
		// Checks for the property A	
		if ( inNumber == sum ) 
			return true;
		else
			return false;
	}
}

