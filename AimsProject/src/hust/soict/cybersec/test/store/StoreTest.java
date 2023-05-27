package hust.soict.cybersec.test.store;
import hust.soict.cybersec.aims.disc.DigitalVideoDisc;
import hust.soict.cybersec.aims.store.Store;

public class StoreTest 
{

	public static void main(String[] args) 
	{
		Store store = new Store();
				
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

		store.addDVD(dvd1);
		store.addDVD(dvd2);
				
		store.print();
		
		store.removeDVD(dvd1);
		store.print();
		
		store.removeDVD(dvd3);
		store.print();
	}

}