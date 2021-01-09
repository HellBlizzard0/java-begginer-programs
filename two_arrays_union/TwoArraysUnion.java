import java.util.Scanner;
import java.util.InputMismatchException;

public class Q3 {
	
	public static void main(String[] args) throws InputMismatchException{
		
		Scanner  k = new Scanner(System.in);
		int arrayOneSize=0, arrayTwoSize=0;	// The sizes of both input arrays
		boolean loop = true;	//Remains true until we reach the program finds the unions
		int[] arrayOne = new int[100], arrayTwo = new int[100],arrayOut = new int[100];	//The two input and output arrays
		
		do {
			
				//Prompts and reads the first array size and elements
				System.out.print("Enter array#1 size: ");	
				arrayOneSize = k.nextInt();
				readArray( arrayOneSize, arrayOne );
				
				//Checks the validity of the array size
				if ( arrayOneSize < 0) {
					System.out.println("Error: Invalid array size.");
					continue;
				}
				
				//Prompts and reads the Second array size and elements
				System.out.print("Enter array#2 size: ");
				arrayTwoSize = k.nextInt();
				readArray( arrayTwoSize, arrayTwo );
				
				//Checks the validity of the array size
				if ( arrayTwoSize < 0) {
					System.out.println("Error: Invalid array size.");
					continue;
				}
	            
				//Checks if the either array size inputs = 0 to skip getting the untion
				if ( arrayOneSize != 0 && arrayTwoSize != 0) {
					//Gets the union array
					arrayOut = getSetUnion (arrayOneSize, arrayOne, arrayTwoSize, arrayTwo);
					
					//if there is NO union in the input arrays
					if (arrayOut.length == 0)
						System.out.println("The Union is: { }");
					
					//if there is union in the input arrays
					else {	
						System.out.print("The Union is: { ");
						for ( int i = 0; arrayOut[i] != -99; i++) {
							if ( arrayOut[ i + 1] != -99) 
								System.out.print(arrayOut[i] + " , ");
							
							else
								System.out.print(arrayOut[i]);
							
						}
					System.out.print(" }\n");
					}
				}
				else 
					System.out.println("The Union is: { }");
				
				//Terminates the loop
				loop = false;
		} while (loop);
			
			
		
	}

	private static int[] getSetUnion(int arrayOneSize, int[] arrayOne, int arrayTwoSize, int[] arrayTwo) {
		int[] arrayOut = new int[50]; int x=0; boolean hasduplicate = false;
		//System.out.print("The union is: { ");
		for ( int i = 0 ; i < arrayOneSize; i ++ ) {			// Nested loop to check for the equal characters in the two arrays
			for ( int j = 0; j < arrayTwoSize; j++ ) {
				if ( arrayOne[i] == arrayTwo[j] ) {		// if checks if int at index i in arrayOne is intersects  with int at index j in arrayTwo and it, the int, is does not appear in arrayOut
					
					for ( int k = 0; k < arrayOut.length; k++) 
						if ( arrayOne[i] == arrayOut[k] )
							hasduplicate = true;
					
					if (!hasduplicate && x == arrayOneSize - 1) {
						arrayOut[x] = arrayTwo[j];	// adds the new intersection to the arrayOut
						x++;
					}
					else if (!hasduplicate) {
						arrayOut[x] = arrayTwo[j];	// adds the new intersection to the arrayOut
						x++;
					}
					hasduplicate = false;
				}
			}
		}
		arrayOut[x] = -99;
		return arrayOut;
	}

	
	private static void readArray(int arraySize, int[] array) {
		
		Scanner  k = new Scanner(System.in);
		
		//For loop to read the input array
		for ( int i=0; i < arraySize; i++) {
				System.out.print("Enter element#" + (i+1)+ ": ");
				array[i] = k.nextInt();
			
			
		}
		
	}

}
