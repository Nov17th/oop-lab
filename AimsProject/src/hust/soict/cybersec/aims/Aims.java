package hust.soict.cybersec.aims;

import hust.soict.cybersec.aims.store.*;
import hust.soict.cybersec.aims.media.*;
import hust.soict.cybersec.aims.cart.Cart;

import javax.naming.LimitExceededException;
import java.util.*;

public class Aims 
{

	private static Store store = new Store();
	private static Cart cart = new Cart();
	
	public static void clearConsole()
	{
		for (int i = 0; i < 15; ++i)
		{
			System.out.println();
		}
	}
	
	public static void initSetup()
	{
		// Create new Book
		Book book1 = new Book("To Kill a Mockingbird", "Fiction", "Harper Lee");
		Book book2 = new Book("The C Programming Language", "Computer Science", 39.99f, "Brian W. Kernighan", "Dennis M. Ritchie");
		Book book3 = new Book("The Wheel of Time Series", "Fantasy", 99.99f, "Robert Jordan", "Brandon Sanderson");
		Book book4 = new Book("The Joy of Cooking", "Cookbook", 27.99f, "Irma S. Rombauer");
				
		store.addMedia(book1, book2, book3, book4);
				
		// Create new DVD
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 15.99f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Godfather", "Drama", 17.99f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 19.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 19.95f);
				
		store.addMedia(dvd1, dvd2, dvd3, dvd4);
				
		// Create new CD
		Track track11 = new Track("Thriller", 6);
		Track track12 = new Track("Beat It", 0);
		Track track13 = new Track("Billie Jean", 5);
		CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 8.99f, track11, track12, track13);
				
		Track track21 = new Track("Back in the U.S.S.R.", 2);
		Track track22 = new Track("Dear Prudence", 4);
		Track track23 = new Track("While My Guitar Gently Weeps", 5);
		CompactDisc cd2 = new CompactDisc("The Beatles (The White Album)", "Rock", "The Beatles", 12.99f, track21, track22, track23);
				
		Track track31 = new Track("Set Fire to the Rain", 4);
		CompactDisc cd3 = new CompactDisc("21", "Pop", "Adele", 10.99f, track31);
			
		CompactDisc cd4 = new CompactDisc("It's Time", "Pop/Jazz", "Michael Bublé");
				
		store.addMedia(cd1, cd2, cd3, cd4);
		
		// Clear console
		clearConsole();
	}

	public static void mediaDetailsMenu(Scanner scanner, Media media) throws LimitExceededException
	{
		outer: while (true)
		{
			System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            
            int option;
			try
			{
				option = Integer.parseInt(scanner.nextLine());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid option! Please enter a number between 0 and 2 \n");
				continue;
			}
			
			switch (option)
			{
				case 0:
					break outer;
				case 1:
                	cart.addMedia(media);
                	cart.getTotalItems();
                	break;
				case 2:
                	if (media instanceof Book)
                	{
                		System.out.println("This type of media is not supported to play.");
                	}
                	else
                	{
                		media.play();
                	}
                	break;
				default:
					System.out.println("Invalid option! Please enter a number between 0 and 2 \n");
					break;
			}
		}
	}
	
	public static void storeMenu(Scanner scanner) throws LimitExceededException
	{
		outer: while (true)
		{
			store.print();
			
			System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");

            int option;
			try
			{
				option = Integer.parseInt(scanner.nextLine());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid option! Please enter a number between 0 and 4 \n");
				continue;
			}
			
            switch (option) 
            {
                case 0:
                    break outer;
                case 1:
                	System.out.println("Enter the title of the media (or type 0 to stop): ");
                	String title = scanner.nextLine();
                	if (title.equals("0"))
                	{
                		break;
                	}

                	Media media = store.searchByTitle(title);
                	if (media != null)
                	{
                		mediaDetailsMenu(scanner, media);
                	}
                	break;
                case 2:
                	System.out.println("Enter the title of the media (or type 0 to stop): ");
                	title = scanner.nextLine();
                	if (title.equals("0"))
                	{
                		break;
                	}
                		
                	media = store.searchByTitle(title);
                	cart.addMedia(media);
                	cart.getTotalItems();
                	break;
                case 3:
                	System.out.println("Enter the title of the media (or type 0 to stop): ");
                	title = scanner.nextLine();
                	if (title.equals("0"))
                	{
                		break;
                	}
                	media = store.searchByTitle(title);
                	if (media instanceof Book)
                	{
                		System.out.println("This type of media is not supported to play.");
                	}
                	else
                	{
                		media.play();
                	}
                	break;
                case 4:
                	cartMenu(scanner);   
                	break;
                default:
					System.out.println("Invalid option! Please enter a number between 0 and 4 \n");
					break;
            }
        }
	}
	
	public static void updateStoreMenu(Scanner scanner)
	{
		outer: while (true)
		{
			store.print();
			
			System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media from store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int option;
			try
			{
				option = Integer.parseInt(scanner.nextLine());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid option! Please enter a number between 0 and 2 \n");
				continue;
			}
			
            subouter: switch (option) 
            {
                case 0:
                    break outer;
                case 1:
                	while (true)
                	{
                		System.out.println("Option: ");
                        System.out.println("--------------------------------");
                        System.out.println("1. Add book to store");
                        System.out.println("2. Add DVD to store");
                        System.out.println("3. Add CD to store");
                        System.out.println("0. Back");
                        System.out.println("--------------------------------");
                        System.out.println("Please choose a number: 0-1-2-3");
                        
                        int addOption;
                        try
            			{
            				addOption = Integer.parseInt(scanner.nextLine());
            			}
            			catch (NumberFormatException ae)
            			{
            				System.out.println("Invalid option! Please enter a number between 0 and 3 \n");
            				continue;
            			}
                        
                        switch (addOption)
                        {
                        	case 0:
                        		break subouter;
                        	case 1:
                        		System.out.println("Enter book title: ");
                        		String title = scanner.nextLine();
                        		System.out.println("Enter book category: ");
                        		String category = scanner.nextLine();
                        		System.out.println("Enter book cost: ");
                        		float cost = 0;
                        		try 
                        		{
                        			cost = Float.parseFloat(scanner.nextLine());
                        		}
                        		catch (NumberFormatException fe)
                        		{
                        			// fe.printStackTrace();
                
                        		}
                        		
                        		Book newBook = new Book(title, category, cost);
                        		System.out.println("Enter authors on seperate lines, end with 0: ");
                        		while (true)
                        		{
                        			String author = scanner.nextLine();
                        			if (author.contains("0"))
                        			{
                        				break;
                        			}
                        			newBook.addAuthor(author);
                        		}
                        		store.addMedia(newBook);
                        		break;
                        	case 2:
                        		System.out.println("Enter DVD title: ");
                        		title = scanner.nextLine();
                        		System.out.println("Enter DVD category: ");
                        		category = scanner.nextLine();
                        		System.out.println("Enter DVD director: ");
                        		String director = scanner.nextLine();
                        		System.out.println("Enter DVD length: ");
                        		int length = 0;
                        		try 
                        		{
                        			length = Integer.parseInt(scanner.nextLine());
                        		}
                        		catch (NumberFormatException ie)
                        		{
                        			// fe.printStackTrace();
                        		}
                        		
                        		cost = 0;
                        		System.out.println("Enter DVD cost: ");
                        		try 
                        		{
                        			cost = Float.parseFloat(scanner.nextLine());
                        		}
                        		catch (NumberFormatException fe)
                        		{
                        			// fe.printStackTrace();
                        		}
                        		
                        		DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, director, length, cost);
                        		store.addMedia(newDVD);
                        		break;
                        	case 3:
                        		System.out.println("Enter CD title: ");
                        		title = scanner.nextLine();
                        		System.out.println("Enter CD category: ");
                        		category = scanner.nextLine();
                        		System.out.println("Enter CD artist: ");
                        		String artist = scanner.nextLine();
                        		cost = 0;
                        		System.out.println("Enter CD cost: ");
                        		try 
                        		{
                        			cost = Float.parseFloat(scanner.nextLine());
                        		}
                        		catch (NumberFormatException fe)
                        		{
                        			// fe.printStackTrace();
                        		}
                        		System.out.println("Enter each track on two separate lines - one for the title and the other for the length.");
                        		System.out.println("End the list with 0.");
                        		
                        		CompactDisc newCD = new CompactDisc(title, category, artist, cost);
                        		
                        		while (true)
                        		{
                        			String trackTitle = scanner.nextLine();
                        			if (trackTitle.contains("0"))
                        			{
                        				break;
                        			}
                        			int trackLength = 0;
                        			try 
                            		{
                        				trackLength = Integer.parseInt(scanner.nextLine());
                            		}
                            		catch (NumberFormatException ie)
                            		{
                            			// fe.printStackTrace();
                            			break;
                            		}
                        			Track newTrack = new Track(trackTitle, trackLength);
                        			newCD.addTrack(newTrack);
                        		}
                        		
                        		store.addMedia(newCD);
                        		break;
                        	default:
                        		System.out.println("Invalid option! Please enter a number between 0 and 3 \n");
            					break;
                        }
                	}
                case 2:
                	System.out.println("Enter the title of the media (or type 0 to stop): ");
                	String title = scanner.nextLine();
                	if (title.equals("0"))
                	{
                		break;
                	}
                		
                	Media media = store.searchByTitle(title);
                	store.removeMedia(media);
                	store.getTotalItems();
                	break;
                default:
                	System.out.println("Invalid option! Please enter a number between 0 and 2 \n");
					break;
            }
		}
	}
	
	public static void cartMenu(Scanner scanner)
	{
		outer: while (true)
		{
			cart.print();
			
			System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            
            int option;
			try
			{
				option = Integer.parseInt(scanner.nextLine());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid option! Please enter a number between 0 and 5 \n");
				continue;
			}
			
            subOuter: switch (option) 
            {
                case 0:
                    break outer;
                case 1:
                	while (true)
                	{
                		System.out.println("Options: ");
                        System.out.println("--------------------------------");
                        System.out.println("1. Filter by ID");
                        System.out.println("2. Filter by Title");
                        System.out.println("0. Back");
                        System.out.println("--------------------------------");
                        System.out.println("Please choose a number: 0-1-2");
                        
                		int filterOption;
            			try
            			{
            				filterOption = Integer.parseInt(scanner.nextLine());
            			}
            			catch (NumberFormatException fe)
            			{
            				System.out.println("Invalid option! Please enter a number between 0 and 2 \n");
            				continue;
            			}
            			
                        switch (filterOption) 
                        {
                            case 0:
                            	break subOuter;
                            case 1:
                            	System.out.println("Enter the id to filter: ");
                            	int id = 0;
                            	try
                            	{
                            		id = Integer.parseInt(scanner.nextLine());
                            	}
                            	catch (NumberFormatException ie)
                            	{
                            		System.out.println("Invalid id! Please try again.");
                            	}                      
                            	Media media = cart.searchByID(id);
                            	break;
                            case 2:
                            	System.out.println("Enter the title to filter: ");
                            	String title  = scanner.nextLine();
   
                            	media = cart.searchByTitle(title);
                            	break;
                            default:
                            	System.out.println("Invalid option! Please enter a number between 0 and 2 \n");
            					break;
                        }
                	}
                case 2:
                	while (true)
                	{
                		System.out.println("Options: ");
                        System.out.println("--------------------------------");
                        System.out.println("1. Sort by Title");
                        System.out.println("2. Sort by Cost");
                        System.out.println("0. Back");
                        System.out.println("--------------------------------");
                        System.out.println("Please choose a number: 0-1-2");
                        
                        int sortOption;
            			try
            			{
            				sortOption = Integer.parseInt(scanner.nextLine());
            			}
            			catch (NumberFormatException ie)
            			{
            				System.out.println("Invalid option! Please enter a number between 0 and 2 \n");
            				continue;
            			}
            			
                        switch (sortOption) 
                        {
                            case 0:
                                break subOuter;
                            case 1:
                            	cart.sortByTitle();
                            	break;
                            case 2:
                            	cart.sortByCost();
                            	break;
                            default:
                            	System.out.println("Invalid option! Please enter a number between 0 and 2 \n");
                            	break;
                        }
                	}
                case 3:
                	System.out.println("Enter the title of the media (or type 0 to stop): ");
                	String title = scanner.nextLine();
                	if (title.equals("0"))
                	{
                		break;
                	}
                		
                	Media media = cart.searchByTitle(title);
                	cart.removeMedia(media);
                	cart.getTotalItems();
                	break;
                case 4:
                	System.out.println("Enter the title of the media (or type 0 to stop): ");
                	title = scanner.nextLine();
                	if (title.equals("0"))
                	{
                		break;
                	}
                		
                	media = cart.searchByTitle(title);
                	if (media instanceof Book)
                	{
                		System.out.println("This type of media is not supported to play.");
                	}
                	else
                	{
                		media.play();
                	}
                	break;
                case 5:
                	if (cart.getTotalItems() <= 0)
                	{
                		System.out.println("Your cart is currently empty, cannot place an order.");
                		break;
                	}
                	System.out.println("An order has been created successfully!");
                	System.out.println("Your cart is currently empty, keep shopping.");
                	cart.empty();
                	break;
                default:
                	System.out.println("Invalid option! Please enter a number between 0 and 5 \n");
                	break;
            }
		}
	}
	
	public static void showMenu() 
	{
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
	
	public static void main(String[] args) throws LimitExceededException
	{
		// Initially add media to store
		initSetup();
		
		// CLI
		while (true)
		{
			showMenu();
			
			Scanner scanner = new Scanner(System.in);
			int option;
			try
			{
				option = Integer.parseInt(scanner.nextLine());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid option! Please enter a number between 0 and 3 \n");
				continue;
			}
			
			switch (option)
			{
				case 0:
					System.out.println("Good bye!");
					scanner.close();
					return;
				case 1:
					storeMenu(scanner);
					break;
				case 2:
					updateStoreMenu(scanner);
					break;
				case 3:
					cartMenu(scanner);
					break;
				default:
					System.out.println("Invalid option! Please enter a number between 0 and 3 \n");
					break;
			}
		}
	}

}
