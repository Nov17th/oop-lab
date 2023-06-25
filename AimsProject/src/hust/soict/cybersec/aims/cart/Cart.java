package hust.soict.cybersec.aims.cart;

import java.util.*;
import hust.soict.cybersec.aims.media.*;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart 
{
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	// Add and remove
	public String addMedia(Media media)
	{
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED)
		{
			return "The cart is almost full.";
		}
		else
		{
			itemsOrdered.add(media);
			return "The media " + media.getTitle() + " has been added.";
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
	public Media searchByID(int id)
	{
		for (int i = 0; i < itemsOrdered.size(); ++i)
		{
			if (itemsOrdered.get(i).getId() == id)
			{
				System.out.println("Match found: ");
				System.out.println(itemsOrdered.get(i).toString());
				return itemsOrdered.get(i);
			}
		}
		System.out.println("No match found.");
		return null;
	}
	
	public Media searchByTitle(String title)
	{
		for (int i = 0; i < itemsOrdered.size(); ++i)
		{
			if (itemsOrdered.get(i).isMatch(title))
			{
				System.out.println("Match found: ");
				System.out.println(itemsOrdered.get(i).toString());
				return itemsOrdered.get(i);
			}
		}
		System.out.println("No match found.");
		return null;
	}
	
	// Sort item
	public void sortByTitle()
	{
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		for (Media media : itemsOrdered)
		{
			System.out.println(media);
		}
	}
	
	public void sortByCost()
	{
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		for (Media media : itemsOrdered)
		{
			System.out.println(media);
		}
	}
	
	// Get number of items in cart
	public int getTotalItems()
	{
		return itemsOrdered.size();
	}

	public ObservableList<Media> getItemsOrdered()
	{
		return itemsOrdered;
	}
	
	// Empty the cart
	public void empty()
	{
		itemsOrdered.clear();
	}

	public String placeOrder()
	{
		if (getTotalItems() <= 0)
		{
			return ("Your cart is currently empty, cannot place an order.");
		}
		empty();
		return "An order has been created successfully!\n" + "Your cart is currently empty, keep shopping.";
	}
}
