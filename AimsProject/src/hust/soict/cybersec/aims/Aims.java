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
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 19.95f);
		anOrder.addMedia(dvd);
		
		Book book = new Book("Star Wars", "Science Fiction", 87);
		book.addAuthor("Steve");
		book.addAuthor("John");
		anOrder.addMedia(book);

		CompactDisc cd = new CompactDisc("Aladin", "Animation", "Artist", 18.99f);
		Track track1 = new Track("TrackName1", 1);
		Track track2 = new Track("TrackName2", 2);
		Track track3 = new Track("TrackName3", 0);
		cd.addtrack(track1);
		cd.addtrack(track2);
		cd.addtrack(track3);
		anOrder.addMedia(cd);
		
		// Print item in cart 
		anOrder.print();
		
		// Playing media
		cd.play();
		dvd.play();
		
		// Print total cost of the items in the cart
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		
		// Removing an existing disc
		anOrder.removeMedia(book);
		anOrder.print();
		
		// Removing a non-existent disc
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Avatar");
		anOrder.removeMedia(dvd1);
		
		// Sorting cart
		anOrder.sortByTitle();
	}

}
