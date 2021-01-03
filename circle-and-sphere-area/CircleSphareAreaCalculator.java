/******************************************************************************
*   Class: CircleSphareAreaCalculator
*   This program calculates either the sphare surface area or circle area
*   given the selection of the user.
*   
*   
*
*   Source: https://github.com/HellBlizzard0/java-begginer-programs/
********************************************************************************/
import java.util.InputMismatchException;
import java.util.Scanner;

public class CircleSphareAreaCalculator {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner k = new Scanner(System. in );
    double cirC = 0,
    cirA = 0,
    cirsum = 0,
    sphV = 0,
    sphA = 0,
    sphsum = 0,
    rad = 0; // cir prefix stands for circle || sph prefix stands for sphere || A = area || V = volume || C = circumference || rad = radius
    int cirnum = 0,
    sphnum = 0,
    choice = 0; // num is a counter for the valid entries || choice is the user interface input

    do {
      try {

        System.out.print("1. Calculate circle area.\r\n" + //User interface
        "2. Calculate sphere surface area.\r\n" + "3. Exit.\r\n" + "Please select your choice:\r\n" + "");
        choice = k.nextInt();

        switch (choice) { //Switch block to handle the choices
        case 1:
          { // Circle area calculator

            System.out.print("Enter the circle circumference [cm]: ");
            cirC = k.nextDouble();
            if (cirC > 0) { // Checks the validity of the input
              rad = cirC / (2 * Math.PI);
              cirA = Math.PI * Math.pow(rad, 2);
              System.out.printf("Circle area = %.2f square cm\nPress Enter hey to continue . . .\n", cirA);
              cirsum += cirA;
              cirnum++;
              k.nextLine();
              k.nextLine();
            }
            else {
              System.out.println("Error: Invalid entry!\nPress Enter hey to continue . . .\n");
              k.nextLine();
              k.nextLine();
            }

            break;
          }
        case 2:
          {

            System.out.print("Enter the sphere volume [cubic cm]: ");
            sphV = k.nextDouble();
            if (sphV > 0) { // Checks the validity of the input
              rad = Math.cbrt(sphV / (4 * Math.PI / 3));
              sphA = 4 * Math.PI * Math.pow(rad, 2);
              System.out.printf("Surface area = %.2f square cm\nPress Enter hey to continue . . .\n", sphA);
              sphsum += sphA;
              sphnum++;
              k.nextLine();
              k.nextLine();
            }
            else {
              System.out.println("Error: Invalid entry!\nPress Enter hey to continue . . .\n");
              k.nextLine();
              k.nextLine();
            }

            break;
          }
        case 3:
          {

            if (cirnum > 0) { // if to generate the average value of the circle areas

              System.out.printf("Number of valid circles = %d\nAverage circle area = %.2f square cm%n", cirnum, cirsum / cirnum);
            }
            else System.out.println("No valid circles were entered.");
            if (sphnum > 0) { // if to generate the average value of the sphere surface areas
              System.out.printf("Number of valid sphere = %d\nAverage Sphere surface area = %.2f square cm", sphnum, sphsum / sphnum);
            }
            else System.out.println("No valid spheres were entered.");

            break;
          }
        default:
          { // an entry error detector
            System.out.println("Error: Invalid Choice!\nPress Enter hey to continue . . .\n");
            k.nextLine();
            k.nextLine();
          }
        }

      }
      catch(InputMismatchException e) { // catches if there was an input mismatch

        System.out.print("Error: " + e + "\nPress Enter key to continue . . .\n");
        k.nextLine();
        k.nextLine();
      }
    } while ( choice != 3 );

  }
}
