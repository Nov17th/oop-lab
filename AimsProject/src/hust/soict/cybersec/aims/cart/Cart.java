package hust.soict.cybersec.aims.cart;

import java.util.*;
import hust.soict.cybersec.aims.media.*;

public class Cart 
{
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();	
	
	// Add and remove
	public void addMedia(Media media)
	{
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED)
		{
			System.out.println("The cart is almost full.");
		}
		else
		{
			itemsOrdered.add(media);
			System.out.println("The media " + media.getTitle() + " has been added.");
		}
	}
	
	public void addMedia(Media[] mediaList)
	{
		if (itemsOrdered.size() + mediaList.length > MAX_NUMBERS_ORDERED)
		{
			System.out.println("The cart is almost full.");
		}
		else
		{
			for (int i = 0; i < mediaList.length; ++i)
			{
				addMedia(mediaList[i]);
			}
			System.out.println("All listed media have been added to the cart.");
		}
	}
	
	public void addMedia(Media media1, Media... mediaList)
	{
		if (itemsOrdered.size() + 1 + mediaList.length > MAX_NUMBERS_ORDERED)
		{
			System.out.println("The cart is almost full.");
		}
		else
		{
			addMedia(media1);
			addMedia(mediaList);
		}
	}

	public void removeMedia(Media media)
	{
		for (int i = 0; i < itemsOrdered.size(); ++i)
		{
			if (itemsOrdered.get(i) == media)
			{
				itemsOrdered.remove(media);
				System.out.println("The media " + media.getTitle() + " has been removed from the cart.");
				return;
			}
		}
		
		System.out.println("The media was not found in the cart.");
	}
	
	// Calculate total cost
	public float totalCost() 
	{
		float totalCost = 0;
		
		for (int i = 0; i < itemsOrdered.size(); ++i)
		{
			totalCost += itemsOrdered.get(i).getCost();
		}
		
		return totalCost;
	}

	// Print items in cart
	public void print()
	{
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); ++i)
		{
			System.out.println(i + 1 + ". " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}

	// Search for item
	public void searchByID(int id)
	{
		for (int i = 0; i < itemsOrdered.size(); ++i)
		{
			if (itemsOrdered.get(i).getId() == id)
			{
				System.out.println("Match found: ");
				System.out.println(itemsOrdered.get(i).toString());
				return;
			}
		}
		System.out.println("No match found.");
	}
	
	public void searchByTitle(String title)
	{
		for (int i = 0; i < itemsOrdered.size(); ++i)
		{
			if (itemsOrdered.get(i).isMatch(title))
			{
				System.out.println("Match found: ");
				System.out.println(itemsOrdered.get(i).toString());
				return;
			}
		}
		System.out.println("No match found.");
	}
	
}
