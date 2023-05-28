package hust.soict.cybersec.test.cart;

import hust.soict.cybersec.aims.media.*;
import hust.soict.cybersec.aims.cart.Cart;

public class CartTest 
{

	public static void main(String[] args) 
	{
		// Create new cart
		Cart cart = new Cart();
		
		// Create new DVD objects and add them to the cart
		Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		
		Media dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		
		Media dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

		cart.addMedia(dvd1, dvd2, dvd3);
		
		// Test to print method
		cart.print();
		
		// Test search methods
		cart.searchByID(2);
		cart.searchByTitle("aladin");
	}

}
