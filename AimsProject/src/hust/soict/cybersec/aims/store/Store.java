package hust.soict.cybersec.aims.store;

import java.util.*;
import hust.soict.cybersec.aims.media.*;

public class Store 
{
	
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media)
	{
		if (itemsInStore.contains(media))
		{
			System.out.println(media.getTitle() + " is already in the store.");
			return;
		}
		itemsInStore.add(media);
		System.out.println(media.getTitle() + " has been added to the store.");
	}
	
	public void addMedia(Media[] mediaList)
	{
		for (Media media : mediaList)
		{
			addMedia(media);
		}
		System.out.println("All of the listed media have been added.");
	}
	
	public void addMedia(Media media1, Media...mediaList)
	{
		addMedia(media1);
		addMedia(mediaList);
	}
	
	public void removeMedia(Media media)
	{
		boolean removed = itemsInStore.remove(media);
		
		if (removed)
		{
			System.out.println(media.getTitle() + " has been removed from the store.");
		}
		else
		{
			System.out.println(media.getTitle() + " is not found in the store.");
		}
	}
	
	public void print()
	{
		for (int i = 0; i < itemsInStore.size(); ++i)
		{
			System.out.println(i + 1 + ". " + itemsInStore.get(i).toString());
		}
	}
	
	// Search for item
	public Media searchByID(int id)
	{
		for (int i = 0; i < itemsInStore.size(); ++i)
		{
			if (itemsInStore.get(i).getId() == id)
			{
				System.out.println("Match found: ");
				System.out.println(itemsInStore.get(i).toString());
				return itemsInStore.get(i);
			}
		}
		System.out.println("No match found.");
		return null;
	}
	
	public Media searchByTitle(String title)
	{
		for (int i = 0; i < itemsInStore.size(); ++i)
		{
			if (itemsInStore.get(i).isMatch(title))
			{
				System.out.println("Match found: ");
				System.out.println(itemsInStore.get(i).toString());
				return itemsInStore.get(i);
			}
		}
		System.out.println("No match found.");
		return null;
	}
	
	// Sort item
	public void sortByTitle()
	{
		Collections.sort(itemsInStore, Media.COMPARE_BY_TITLE_COST);
		for (Media media : itemsInStore)
		{
			System.out.println(media);
		}
	}
	
	public void sortByCost()
	{
		Collections.sort(itemsInStore, Media.COMPARE_BY_COST_TITLE);
		for (Media media : itemsInStore)
		{
			System.out.println(media);
		}
	}
	
	// Get number of items in store
	public int getTotalItems()
	{
		return itemsInStore.size();
	}
	
}

