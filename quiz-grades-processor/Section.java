import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Section {

	int numStudents;
	final int MAXIMUMCAPACITY = 30;
	// A Student array of objects to get students information
	Student[] students = new Student[MAXIMUMCAPACITY];
	

	public Section() throws IllegalArgumentException, FileNotFoundException {
		
		
				// This scanner declaration + loop collects all the students' data from the input file
				Scanner fileInfoCollector = new Scanner(new FileInputStream("QuizGrades.txt"), "UTF-8");
				
				
				// loop to extract each student's information individually per loop, stops iterating at the end of the file or if it have collected information for 30 students 
				for ( int i = 0; fileInfoCollector.hasNextLine() && i < 30; i++) {
					
					// Scans a line of the QuizGrades.txt
					Scanner line = new Scanner(fileInfoCollector.nextLine());
					double[] stdGrade = new double [5];
					int stdId = line.nextInt(); String stdName = line.next() + " " + line.next();
					for ( int j = 0; j < stdGrade.length; j++ )
						stdGrade[j] = line.nextDouble();
					// Passes the information of the student to the Student array.
					students[i] = new Student ( stdId, stdName, stdGrade);
					this.numStudents = i + 1;
					line.close();	
				}
				
				fileInfoCollector.close();
				
		if ( numStudents < 5 || numStudents > MAXIMUMCAPACITY )
			throw new IllegalArgumentException("");
		
				
		
	}
	
	// Returns a reference to the Student array
	public Student[] getStudentArray() {
		return students;
	}
	
	// receives the ID of a student and check if there is a student with that ID.
	public boolean doesIdMacth ( int studentId) {
		
		// Search for a student with the specified ID.
				for (int i = 0; i < numStudents; i++)
					if ( studentId == students[i].getStudentId())
						return true;
				
				return false;
	}
	
	// receives the ID of a student and returns the information if said student.
	public String getStudentInfo(int studentId) {
						
		// Search for a student with the specified ID.
		for (int i = 0; i < numStudents; i++)
			if ( studentId == students[i].getStudentId())
				return students[i].toString();
		
		return "Error";
	}
		
	// receives the number of the required quiz and returns the students' average of that quiz.
	public double getSectionQuizAverage(int quizNumber) throws IllegalArgumentException{
		
		if ( quizNumber > 5 || quizNumber < 1 )
			throw new IllegalArgumentException("Invalid quiz number");
		
		// Sums the quizzes of the students on the specified quiz
		double sum = 0; int i;
		for (i = 0; i < numStudents; i++)
			sum += students[i].quizGrades[quizNumber - 1];
		
		return sum / i; // Check how to replace the i with numStudents
	}
	
	// returns a formatted string containing id, studentName, and five quiz grades.
	public String toString() {
		String info = "";
		for ( int i = 0; i < 20; i++) {
			info += students[i].toString() + "\n";
		}
		return info;
	}
}
