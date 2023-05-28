package hust.soict.cybersec.aims.store;

import java.util.*;
import hust.soict.cybersec.aims.media.*;

public class Store 
{
	
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media)
	{
		itemsInStore.add(media);
		System.out.println(media.getTitle() + " has been added to the store.");
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
			System.out.println(itemsInStore.get(i).toString());
		}
	}
	
}

