package hust.soict.cybersec.lab01.JavaBasics;
// Exercise 6.1: Write, compile and run the ChoosingOption program

// Example code
// import javax.swing.JOptionPane;
//
// public class ChoosingOption 
// {
//
//	 public static void main(String[] args) 
//	 {
//	 	 int option = JOptionPane.showConfirmDialog(null, 
//					 "Do you want to change to the first class ticker?");
//		
//		 JOptionPane.showMessageDialog(null, "You've chosen: "
//					 + (option == JOptionPane.YES_OPTION? "Yes" : "No"));
//		 System.exit(0);
//	 }
//
// }

import javax.swing.*;

public class ChoosingOption
{
	public static void main(String[] args)
	{
		Object questionMessage = "Do you want to change to the first class ticket?";
		Object confirmMessage = "You've been choosen: ";
		
		// Default option: "Yes", "No" and "Cancel"
		int option = JOptionPane.showConfirmDialog(null, questionMessage);
		// Display "Yes" for a confirmed "Yes" answer, otherwise display "No"
		JOptionPane.showMessageDialog(null, confirmMessage + (option == JOptionPane.YES_OPTION? "Yes" : "No"));
		
		// // Customize the option: only two options "Yes" and " No"
        // int option = JOptionPane.showConfirmDialog(null, questionMessage, null, JOptionPane.YES_NO_OPTION);
        // JOptionPane.showMessageDialog(null, confirmMessage + (option == JOptionPane.YES_OPTION? "Yes" : "No"));
        
        // // Customize the option: only two options "I do" and "I don't"
        // Object[] possibleValues = {"I do", "I don't"}; 
        // int option = JOptionPane.showOptionDialog(null, questionMessage, null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, possibleValues, null);
        // JOptionPane.showMessageDialog(null, confirmMessage + (option == JOptionPane.YES_OPTION? "I do" : "I don't"));
		
		System.exit(0);
	}
}
