// Exercise 6.6: Write a Java program to add two matrices of the same size

import java.util.*;

public class MatrixAddition 
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the number of row: ");
        int row = keyboard.nextInt();
        System.out.print("Enter the number of column: ");
        int column = keyboard.nextInt();

        int[][] firstMatrix = new int[row][column];
        int[][] secondMatrix = new int[row][column];
        System.out.println("Enter the first matrix: ");
        for (int i = 0; i < row; ++i)
        {
            for (int j = 0; j < column; ++j)
            {
                firstMatrix[i][j] = keyboard.nextInt();
            }
        }
        System.out.println("Enter the second matrix: ");
        for (int i = 0; i < row; ++i)
        {
            for (int j = 0; j < column; ++j)
            {
                secondMatrix[i][j] = keyboard.nextInt();
            }
        }
        keyboard.close();

        System.out.println("The addition matrix is: ");
        for (int i = 0; i < row; ++i)
        {
            for (int j = 0; j < column; ++j)
            {
                System.out.print((firstMatrix[i][j] + secondMatrix[i][j]) + " ");
            }
            System.out.println();
        }
	}

}
