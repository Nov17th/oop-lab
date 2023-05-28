package hust.soict.cybersec.aims.cart;
import hust.soict.cybersec.aims.media.DigitalVideoDisc;

public class Cart 
{
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc)
	{
		if (qtyOrdered >= MAX_NUMBERS_ORDERED)
		{
			System.out.println("The cart is almost full.");
		}
		else
		{
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc " + disc.getTitle() + " has been added.");
		}
	}
	
	public void addDigitalVideoDisc (DigitalVideoDisc[] dvdList)
	{
		if (qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED)
		{
			System.out.println("The cart is almost full.");
		}
		else
		{
			for (int i = 0; i < dvdList.length; ++i)
			{
				addDigitalVideoDisc(dvdList[i]);
			}
			System.out.println("All listed discs have been added to the cart.");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc... dvdList)
	{
		if (qtyOrdered + 1 + dvdList.length > MAX_NUMBERS_ORDERED)
		{
			System.out.println("The cart is almost full.");
		}
		else
		{
			addDigitalVideoDisc(dvd1);
			addDigitalVideoDisc(dvdList);
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc)
	{
		boolean exist = false;
		
		for (int i = 0; i < qtyOrdered; ++i)
		{
			if (itemsOrdered[i] == disc)
			{
				exist = true;
				for (int j = i; j < qtyOrdered - 1; ++j)
				{
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				qtyOrdered -= 1;
				break;
			}
		}
		
		if (!exist)
		{
			System.out.println("The disc was not found in the cart.");
		}
		else
		{
			System.out.println("The disc has been removed from the cart.");
		}
	}
	
	public float totalCost() 
	{
		float totalCost = 0;
		
		for (int i = 0; i < qtyOrdered; ++i)
		{
			totalCost += itemsOrdered[i].getCost();
		}
		
		return totalCost;
	}

	public void print()
	{
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; ++i)
		{
			System.out.println(itemsOrdered[i].toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}

	public void searchByID(int id)
	{
		for (int i = 0; i < qtyOrdered; ++i)
		{
			if (itemsOrdered[i].getId() == id)
			{
				System.out.println("Match found: ");
				System.out.println(itemsOrdered[i].toString());
				return;
			}
		}
		System.out.println("No match found.");
	}
	
	public void searchByTitle(String title)
	{
		for (int i = 0; i < qtyOrdered; ++i)
		{
			if (itemsOrdered[i].isMatch(title))
			{
				System.out.println("Match found: ");
				System.out.println(itemsOrdered[i].toString());
				return;
			}
		}
		System.out.println("No match found.");
	}
	
}
