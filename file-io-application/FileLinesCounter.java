/******************************************************************************
*   Class: FileLinesCounter
*   This program prompts a valid input file name. It then opens the file and
*   counts the numbers of each line in the input file. Finally, the program 
*   outputs the results in an output.txt file.
*
*   Please refer to the 'input.txt' and 'output.txt' files for example.
*
*   Source: https://github.com/HellBlizzard0/java-begginer-programs/
********************************************************************************/
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileLinesCounter {

  public static void main(String[] args) throws FileNotFoundException {

    int count = 0,
    filelinenumber = 1; // count is to count the number of capital letters || filelinenumber is to print the line number in the output file
    try {
      Scanner k = new Scanner(System. in );
      System.out.println("Please enter the name of the input file [The full address]: ");
      Scanner infile = new Scanner(new FileInputStream(k.nextLine())); // Starting from "C://" or "D://" 
      PrintWriter outfile = new PrintWriter(new FileOutputStream("output.txt")); // output file has a constant name for simplicity 
      String line = infile.nextLine(); // reads first line to confirm the existence of the required file
      outfile.println("Line#		Required word count");

      do { // A loop to read each line separately
        outfile.print("	" + filelinenumber + "				");

        for (int i = 0; i < line.length(); i++) { // inner loop to go through each line one by one
          if (Character.isUpperCase(line.charAt(i))) { // Checks if a the char at index (i) is upper case and count if the condition is satisfied
            count++;
          }
        }

        outfile.println(count); // prints the sum of upper case characters in the current line
        line = infile.nextLine(); // scans the next line for the next iteration
        count = 0; // reset the counter to zero
        filelinenumber++;

      } while ( infile . hasNextLine ()); { //Block statement to test the last line in the file
        outfile.print("	" + filelinenumber + "				");

        for (int i = 0; i < line.length(); i++) { // inner loop to go through each line one by one
          if (Character.isUpperCase(line.charAt(i))) { // Checks if a the char at index (i) is upper case and count if the condition is satisfied
            count++;
          }
        }

        outfile.println(count); // prints the sum of upper case characters in the current line
      }
      System.out.println("Outfile.txt has been generated.\nProgram terminated.");
      outfile.close();
      infile.close();
      System.exit(0);
    }
    catch(FileNotFoundException e) { // catches if the file is empty or does not exist
      System.out.println("Error: Input file is not found or empty!");
      System.exit(0);
    }

  }

}
