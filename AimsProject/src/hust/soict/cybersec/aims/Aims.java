package hust.soict.cybersec.aims;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.*;

public class Aims 
{

	public static void main(String[] args) 
	{
		// Create a new cart
		Cart anOrder = new Cart();
		
		// Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addMedia(dvd1);
		
		Book dvd2 = new Book("Star Wars", "Science Fiction", 87);
		anOrder.addMedia(dvd2);

		CompactDisc dvd3 = new CompactDisc("Aladin", "Animation", "Artist", 18.99f);
		anOrder.addMedia(dvd3);
		
		// Print item in cart 
		anOrder.print();
		
		// Print total cost of the items in the cart
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		
		// Removing an existing disc
		anOrder.removeMedia(dvd2);
		anOrder.print();
		
		// Removing a non-existent disc
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar");
		anOrder.removeMedia(dvd4);
	}

}
