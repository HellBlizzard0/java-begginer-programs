/******************************************************************************
*   Class: StringIntersectionFinder
*   This program prompts 2 strings and finds the their intersection.
*
*   Source: https://github.com/HellBlizzard0/java-begginer-programs/
********************************************************************************/
import java.util.Scanner;
import java.util.InputMismatchException;

public class StringIntersectionFinder {

  public static void main(String[] args) {

    String str1 = "",
    str2 = "",
    strout = ""; // str1 and str2 are the input strings || strout is the output string
    int L1 = 0,
    L2 = 0; // L means length of each string
    Scanner k = new Scanner(System. in );

    System.out.print("Enter string1 of distinct characters: ");
    str1 = k.nextLine();
    System.out.print("Enter string2 of distinct characters: ");
    str2 = k.nextLine();

    for (int i = 0; i < str1.length(); i++) { // Nested loop to check for the equal characters in the two strings
      for (int j = 0; j < str2.length(); j++) {
        if ((str1.charAt(i) == str2.charAt(j)) && (strout.indexOf(str2.charAt(j)) < 0)) { // if checks if char at indext i in str1 is intersects  with char at index j in str2 and it, the char, is does not appear in strout
          strout += str2.charAt(j); // adds the new intersection to the strout
        }
      }
    }
    if (strout.isEmpty()) System.out.println("The intersection is empty: {" + strout + "}");
    else System.out.println("The intersection is: {" + strout + "}");

  }

}
