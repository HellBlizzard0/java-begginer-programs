import java.util.*;
import java.io.*;

public class QuizGradesProcessor {

	
	public static void main(String[] args) throws FileNotFoundException  {

		boolean loop = true;
		Scanner k = new Scanner(System.in);
		
		ICS102Section sec = new ICS102Section();

		do { 
			try {
				
				SectionDriver.displayStartUpMessage();
				int choice = k.nextInt();
				
				switch (choice) {
					case 1:{
						
						System.out.println("\tID\t\tNAME\t\tQZ1\tQZ2\tQZ3\tQZ4\tQZ5");
						System.out.print(sec.toString());
						
						resetInputBuffer();
						break;
					}
					case 2:{
						
						System.out.print("Enter the required quiz number [1 - 5]: ");
						int quizNumber = k.nextInt();
						System.out.printf("The section average for quiz#%d is %.1f", 
								quizNumber, sec.getSectionQuizAverage(quizNumber));
						
						resetInputBuffer();
						break;
					}
					case 3:{
						
						System.out.print("Enter the ID# of the student: ");
						int studentId = k.nextInt();
						if ( sec.doesIdMacth(studentId)) {
							System.out.println("\tID\t\tNAME\t\tQZ1\tQZ2\tQZ3\tQZ4\tQZ5");
							System.out.println(sec.getStudentInfo(studentId));
						}
						else 
							System.out.println("Error: student not found.");
						
						resetInputBuffer();
						break;
					}
					case 4:{
						
						loop = false;
						break;
					}
					default: {
						throw new IllegalArgumentException("Invalid input");
					}
				}
				
				
			}
			catch (IllegalArgumentException e) {
				System.out.println(e);
				resetInputBuffer();
			}
			catch (InputMismatchException e) {
				System.out.println("Error: " + e);
				resetInputBuffer();
			}
		} while (loop);
		
		k.close();
	}

		private static void resetInputBuffer() {
		Scanner k = new Scanner(System.in);
		System.out.println("\nPress enter key to continue . . .");
		k.nextLine();
	}
	
}
