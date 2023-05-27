package hust.soict.cybersec.lab01.JavaBasics;
// Exercise 6.3: Write a program to display a triangle with a height of n stars (*), n is entered by users

import java.util.Scanner;

public class DisplayTriangle 
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter the height: ");
        int input = keyboard.nextInt();
        keyboard.close();
        
        for (int i = 0; i < input; ++i)
        {
            System.out.println(" ".repeat(input - i - 1) + "*".repeat(i * 2 + 1));
        }
	}

}
