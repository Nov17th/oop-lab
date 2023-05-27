/*
 * Exercise 6.5: Write a Java program to sort a numeric array, and calculate the sum and average 
 * value of array elements.
 */

import java.util.*;

public class NumericArray 
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter the array size: ");
        int arraySize = keyboard.nextInt();

        int[] numArray = new int[arraySize];
        int total = 0;
        System.out.print("Enter the array: ");
        for (int i = 0; i < arraySize; ++i)
        {
            numArray[i] = keyboard.nextInt();
            total += numArray[i];
        }
        keyboard.close();

        Arrays.sort(numArray);
        System.out.print("The sorted array is: ");
        for (int value : numArray)
        {
            System.out.print(value + " ");
        }

        System.out.println("\nThe sum of the array is: " + total);
        System.out.println("The average of the array is: " + (double)total / arraySize);
	}

}
