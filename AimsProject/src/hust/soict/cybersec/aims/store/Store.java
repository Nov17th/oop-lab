package hust.soict.cybersec.aims.store;
import java.util.*;

import hust.soict.cybersec.aims.disc.DigitalVideoDisc;

public class Store 
{
	
	private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
	
	public void addDVD(DigitalVideoDisc dvd)
	{
		itemsInStore.add(dvd);
		System.out.println(dvd.getTitle() + " has been added to the store.");
	}
	
	public void removeDVD(DigitalVideoDisc dvd)
	{
		boolean removed = itemsInStore.remove(dvd);
		
		if (removed)
		{
			System.out.println(dvd.getTitle() + " has been removed from the store.");
		}
		else
		{
			System.out.println(dvd.getTitle() + " is not found in the store.");
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
