/******************************************************************************
*   Class: WeekDayCalculator
*   This program prompts a valid year, month and day in integer form. It outputs 
*   the day of the week the of the given input.
*   For example:   
*   input [DD/MM/YYYY]: 13/02/2018
*   output: "The day name of for 13/2/2018 is Tuesday."
*
*   Source: https://github.com/HellBlizzard0/java-begginer-programs/
********************************************************************************/
import java.util.Scanner;
import java.util.InputMismatchException;

public class WeekDayCalculator {

    public static void main(String[] args) {
        int day = 0, month = 0, year = 0, daymax = 0, weekday = 0, compmonth, compyear, k, y; // daymax means the maximum number of days in selected month || compmonth and compyear are the computed month and year, respectively || k and y are indicated in the question
        String dayname = "Error"; // dayname is set to "Error" by default for debugging purposes
        Scanner kb = new Scanner(System.in);

        try {

            System.out.print("Enter year [1582 - 4000]: ");
            year = kb.nextInt();

            if (year > 4000 || year < 1582) { // Error detector if the user entered a year outside the boundry [ 1582 - 4000 ]

                System.out.println("Error: Invalid year.");
                System.exit(1);

            }

            System.out.print("Enter month[1 - 12]: ");
            month = kb.nextInt();

            if (month > 12 || month < 1) { // Error detector if the user entered a year outside the boundry [ 1 - 12 ]

                System.out.println("Error: Invalid month.");
                System.exit(1);

            }
            if (month == 2) { // Nested if to set the daymax

                if (year % 400 == 0 || year % 4 == 0 && year % 4 != 0) { // Then feb has 29 days
                    daymax = 29;
                    System.out.print("Enter day [1 - 29]: ");
                    day = kb.nextInt();
                } else {
                    daymax = 28;
                    System.out.print("Enter day [1 - 28]: ");
                    day = kb.nextInt();

                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                daymax = 30;
                System.out.print("Enter day [1 - 30]: ");
                day = kb.nextInt();

            } else {
                daymax = 31;
                System.out.print("Enter day [1 - 31]: ");
                day = kb.nextInt();

            }

        } catch (InputMismatchException err) { // Input error handler

            System.out.println("Error: " + err);
            System.exit(1);

        }

        if (day > daymax) { // Nested if to handle the input error of the days

            if (daymax == 28) {
                System.out.println("Error: The maximum number of days for month " + month + " in a non-leap year is " + daymax);
                System.exit(1);
            } else if (daymax == 29) {
                System.out.println("Error: The maximum number of days for month " + month + " in a leap year is " + daymax);
                System.exit(1);
            } else if (daymax == 30) {
                System.out.println("Error: The maximum number of days for month " + month + " is " + daymax);
                System.exit(1);
            } else if (daymax == 29) {
                System.out.println("Error: The maximum number of days for month " + month + " is " + daymax);
                System.exit(1);
            }

        } else if (day < 1) {
            System.out.println("Error: the minimum numver of days is 1");
        }

        if (month == 1 || month == 2) { // calculates the compmonth and the compyear
            compmonth = month + 12;
            compyear = year - 1;
        } else {
            compyear = year;
            compmonth = month;
        }
        k = compyear / 100;
        y = compyear % 100;

        weekday = (day + (13 * compmonth + 1) / 5 + y + y / 4 + k / 4 + 5 * k) % 7;

        switch (weekday) { // assigns the proper day name

            case 0:
                {
                    dayname = "Tuesday";
                    break;
                }
            case 1:
                {
                    dayname = "Wednesday";
                    break;
                }
            case 2:
                {
                    dayname = "Thursday";
                    break;
                }
            case 3:
                {
                    dayname = "Friday";
                    break;
                }
            case 4:
                {
                    dayname = "Saturday";
                    break;
                }
            case 5:
                {
                    dayname = "Sunday";
                    break;
                }
            case 6:
                {
                    dayname = "Monday";
                    break;
                }

        }
        System.out.printf("The day name for %d/%d/%d is %s.", day, month, year, dayname);

    }

}


}
