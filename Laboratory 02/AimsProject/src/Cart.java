public class Cart 
{
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc)
	{
		if (qtyOrdered >= MAX_NUMBERS_ORDERED)
		{
			System.out.println("The cart is almost full");
		}
		else
		{
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc has been added");
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
}
