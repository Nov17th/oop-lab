/* 
 * Exercise 6.4: Write a program to display the number of days of a month, which is entered by users 
 * (both month and year). If it is an invalid month/year, ask the user to enter again. 
 */

import java.util.*;

public class NumberOfDays 
{
	private ArrayList<String> month;
	
	private void setUpMonth()
    {
        month = new ArrayList<String>();
        month.addAll(Arrays.asList("january", "february", "march", "april", "may", "june",
                                    "july", "august", "september", "october", "november", "december"));
        for (int i = 0; i < month.size(); i += 4)
        {
            String currMonth = month.get(i);
            String tmp = currMonth.substring(0, 3);
            if (currMonth.length() <= 4)
            {
                month.add(i + 1, currMonth);
            }
            else if (currMonth.equals("september"))
            {
                month.add(i + 1, currMonth.substring(0, 4) + '.');
            }
            else
            {
                month.add(i + 1, tmp + '.');
            }
            month.add(i + 2, tmp);
            month.add(i + 3, String.valueOf(i/4 + 1));
        }
    }

    private int getDaysOfMonth(int monthID, int year)
    {
        int currMonth = monthID/4 + 1;
        if (currMonth == 2)
        {
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
            {
                return 29;
            }
            else
            {
                return 28;
            }
        }
        if (((currMonth <= 7) && (currMonth % 2 != 0)) || ((currMonth > 7) && (currMonth % 2 == 0)))
        {
            return 31;
        }
        return 30;
    }
	
	public static void main(String[] args) 
	{
		NumberOfDays nod = new NumberOfDays();
        nod.setUpMonth();
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter a month (example: January, Jan., Jan or 1): ");
        String inputMonth = keyboard.next().trim().toLowerCase();

        int checkMonthValid = nod.month.indexOf(inputMonth);
        if (checkMonthValid == -1)
        {
            System.out.println("Invalid month. Please enter a valid month.");
            keyboard.close();
            System.exit(0);
        }

        System.out.println("Enter a year (example: 1999): ");
        int inputYear = keyboard.nextInt();
        keyboard.close();
        if (inputYear <= 0)
        {
            System.out.println("Invalid year. Please enter a non-negative number.");
            System.exit(0);
        }

        System.out.println("The number of days in " + inputMonth.substring(0, 1).toUpperCase() 
                            + inputMonth.substring(1) + " " + inputYear + " is: "+ nod.getDaysOfMonth(checkMonthValid, inputYear));
	}

}
