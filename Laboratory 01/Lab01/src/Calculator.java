/* 
 * Write a program to calculate sum, difference, product, and quotient 
 * of 2 double numbers which are entered by users.
*/

import javax.swing.JOptionPane;

public class Calculator
{

	public static void main(String[] args) 
	{
		String strNum1, strNum2;
		
		String strNotification = "";
		
		
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", 
												"Input the first number", JOptionPane.INFORMATION_MESSAGE);
		
		strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ",
												"Input the second number", JOptionPane.INFORMATION_MESSAGE);
		
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		
		double sum = num1 + num2;
		double diff = num1 - num2;
		double product = num1 * num2;
		
		strNotification += ("Sum: " + sum + "\n Difference: " + diff + 
							"\n Product: " + product);
		if (num2 != 0)
		{
			double quotient = num1 / num2;
			strNotification += ("\n Quotient: " + quotient);
		}
		
		JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	
}
