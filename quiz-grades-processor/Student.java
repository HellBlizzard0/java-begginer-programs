import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Student {

	final int Id;	
	final String StudentName;
	
	double[] quizGrades = new double[5];
	
	public Student ( int id, String studentName, double[] quizGrades) throws  FileNotFoundException{
		this.Id = id;
		this.StudentName = studentName;
		this.quizGrades = quizGrades;	
	}
	
	// Returns a quiz score for the specified quiz number.
	public double getQuizScore( int numOfQuiz) {
		return quizGrades[numOfQuiz - 1];
	}
	
	// Returns a formatted string containing id, studentName, and five quiz grades.
	public String toString( )  {
		
		String s = Id + "\t" + StudentName + "\t";
		for (int i = 0; i < 5; i++ )
			// The selection statement is only for formatting the grades
			if ( StudentName.length() >= "AbdulAziz Zubeir".length() && i == 0)
				s += "" + quizGrades[i] + " ";
			else
				s += "\t" + quizGrades[i] + " ";
		
		return s;
	}
	
	// Returns the ID number.
	public int getStudentId() {
		return Id;
	}
}
