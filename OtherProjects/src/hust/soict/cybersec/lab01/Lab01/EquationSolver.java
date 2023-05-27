package hust.soict.cybersec.lab01.Lab01;
/* 
 * Write a program to solve linear equation with one variable, 
 * linear system with two variables and quadratic equation with one variable.
*/

import javax.swing.JOptionPane;

public class EquationSolver 
{
	public static void displayMenu()
	{
		String menu = "Equation Solver Menu\n";
		menu += "1. Solve a linear equation with one variable\n";
		menu += "2. Solve a linear system with two variables\n";
		menu += "3. Solve a quadratic equation with one variable\n";
		menu += "4. Exit the program\n";
		JOptionPane.showMessageDialog(null, menu);
	}
	
	public static void main(String[] args) 
	{
		int choice;
		do 
		{
			displayMenu();
			choice = Integer.parseInt(JOptionPane.showInputDialog("Enter your choice:"));
			switch (choice)
			{
				case 1:
					LinearEquationSolver les = new LinearEquationSolver();
					les.solver();
					break;
				case 2:
					LinearSystemSolver lss = new LinearSystemSolver();
					lss.solver();
					break;
				case 3: 
					QuadraticEquationSolver qes = new QuadraticEquationSolver();
					qes.solver();
					break;
				case 4:
					JOptionPane.showMessageDialog(null,"Exiting the program...");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a number from 1 to 4");
					break;					
			}
		} while (choice != 4);

	}

}

record LinearEquationSolver(double a, double b) 
{
    public LinearEquationSolver() 
    {
        this(Double.parseDouble(JOptionPane.showInputDialog("Enter the value of a:")),
             Double.parseDouble(JOptionPane.showInputDialog("Enter the value of b:")));
    }

    public void solver() 
    {
        if (a == 0) 
        {
            if (b == 0) 
            {
                JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.");
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "The equation has no solutions.");
            }
        } 
        else 
        {
            double x = - b / a;
            JOptionPane.showMessageDialog(null, "The solution is x = " + x);
        }
    }
}

record LinearSystemSolver(double a11, double a12, double b1, double a21, double a22, double b2)
{
	public LinearSystemSolver()
	{
		this(Double.parseDouble(JOptionPane.showInputDialog("Enter the value of a11:")),
			 Double.parseDouble(JOptionPane.showInputDialog("Enter the value of a12:")),
			 Double.parseDouble(JOptionPane.showInputDialog("Enter the value of b1:")),
			 Double.parseDouble(JOptionPane.showInputDialog("Enter the value of a21:")),
			 Double.parseDouble(JOptionPane.showInputDialog("Enter the value of a22:")),
			 Double.parseDouble(JOptionPane.showInputDialog("Enter the value of b2:")));
	}
	
	public void solver()
	{
		double determinant = a11 * a22 - a12 * a21;
		
		if (determinant == 0)
		{
			if (b1 == 0 && b2 == 0)
			{
				JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "The system has no solutions.");
			}
		}
		else
		{
			double x1 = (b1 * a22 - b2 * a12) / determinant;
			double x2 = (b2 * a11 - b1 * a21) / determinant;
			JOptionPane.showMessageDialog(null, "The solution is x1 = " + x1 + " and x2 = " + x2 + ".");
		}
	}
}

record QuadraticEquationSolver(double a, double b, double c)
{
	public QuadraticEquationSolver()
	{
		this(Double.parseDouble(JOptionPane.showInputDialog("Enter the value of a:")),
			 Double.parseDouble(JOptionPane.showInputDialog("Enter the value of b:")),
			 Double.parseDouble(JOptionPane.showInputDialog("Enter the value of c:")));
	}
	
	public void solver()
	{
		if (a == 0)
		{
			LinearEquationSolver temp = new LinearEquationSolver(b, c);
			temp.solver();
		}
		else
		{
			double delta = b * b - 4 * a * c;
			
			if (delta < 0)
			{
				JOptionPane.showInternalMessageDialog(null, "The equation has no real roots.");
			}
			else
			{
				if (delta == 0)
				{
					double root = - b / (2 * a);
					JOptionPane.showMessageDialog(null, "The equation has a double root of " + root + ".");
				}
				else
				{
					double root1 = (-b + Math.sqrt(delta)) / (2 * a);
					double root2 = (-b - Math.sqrt(delta)) / (2 * a);
					JOptionPane.showMessageDialog(null, "The roots are " + root1 + " and " + root2 + ".");
				}
			}
		}
	}
}
