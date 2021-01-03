/******************************************************************************
*   Class: DecimalNumberChecker
*   This class prompts a number 'n' and compares two float numbers up to 'n' 
*   decimal places.
*
*   Source: https://github.com/HellBlizzard0/java-begginer-programs/new/main
********************************************************************************/
import java.util.Scanner;
import java.util.InputMismatchException;

public class DecimalNumberChecker {

    public static void main(String[] args) {

        int j = 1; // The loop counter
        int deccheck = 0, n = 0; // deccheck is a counter for how many decimal numbers are equal || n is the number of decimal places to check to check, provided by the user
        double val1 = 0, val2 = 0; // valx is the value provided by the user

        Scanner kb = new Scanner(System.in);

        try {

            System.out.print("Enter an integer number n for the decimal places [ 0 - 10 ]: ");
            n = kb.nextInt();

            if (n < 0 || n > 10) { // Error detector if the user entered an integer outside the boundry [ 0 - 10 ]
                System.out.println("Error: n is outside the boundry [ 0 - 10 ]");
                System.exit(1);
            }
            System.out.print("Input floating-point number: ");
            val1 = kb.nextDouble();

            System.out.print("Input floating-point number: ");
            val2 = kb.nextDouble();


        } catch (InputMismatchException err) { // Input error handler

            System.out.println("Error: " + err);
            System.exit(1);

        }



        while (j <= n) { // loop to check the degree of equality between the two values

            if ((int)(val1 * 10) == (int)(val2 * 10)) { // checks if the next decimal places are equal provided that the integer parts of the numbers are equal
                deccheck++;
            }
            val1 *= 10; // updates the values before the next cycle
            val2 *= 10;
            j++;
        }

        System.out.println("The number are equal up to " + deccheck + " decimal places");

    }

}
