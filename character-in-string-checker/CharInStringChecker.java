/******************************************************************************
*   Class: CharInStringChecker
*   This program prompts the user a string and a character. It then checks if 
*   the string contains the character.
*
*   Source: https://github.com/HellBlizzard0/java-begginer-programs/
********************************************************************************/
import java.util.Scanner;
import java.util.InputMismatchException;

public class CharInStringChecker {

    public static void main(String[] args) {

        String word1 = "", word2 = ""; // wordx are the strings provided by the user, set to an empty string for debugging purposes
        char ch1 = 0, ch2 = 0; // chx are the characters provided by the user, set to zero for debugging purposes
        Scanner kb = new Scanner(System.in);

        try {

            System.out.println("Please enter word1:");
            word1 = kb.nextLine();

            System.out.println("Please enter character1:");
            ch1 = kb.next().charAt(0);
            if (word1.indexOf(ch1) == -1) { // Error detector, triggered by inputting a character that is not present in the string
                System.out.println("Error: The character " + ch1 + " does not appear in word1");
                System.exit(1);
            }

            kb.nextLine(); // Input dummy to remove the new line character
            System.out.println("Please enter word2:");
            word2 = kb.nextLine();

            System.out.println("Please enter character2:");
            ch2 = kb.next().charAt(0);
            if (word2.indexOf(ch2) == -1) { // Error detector, triggered by inputting a character that is not present in the string
                System.out.println("Error: The character " + ch2 + " does not appear in word2");
                System.exit(1);
            }
        } catch (InputMismatchException err) { // Input error handler

            System.out.println("Error: " + err);
            System.exit(1);
        }
        word1 = word1.replace(ch1, ch2); //replaces the characters of the first string
        System.out.println("The new word1 is " + word1);
        word2 = word2.replace(ch2, ch1); //replaces the characters of the second string
        System.out.println("The new word2 is " + word2);
    }

}

}
