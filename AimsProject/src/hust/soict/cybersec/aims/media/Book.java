package hust.soict.cybersec.aims.media;

import java.util.*;

public class Book extends Media
{

	private List<String> authors = new ArrayList<String>();
	
	// Constructors
	public Book(String title) 
	{
		super(title);
	}
	
	public Book(String title, String category)
	{
		super(title, category);
	}
	
	public Book(String title, String category, float cost)
	{
		super(title, category, cost);
	}
	
	// Add and remove author
	public void addAuthor(String authorName)
	{
		if (authors.contains(authorName))
		{
			System.out.println("Author already in list.");
		}
		else
		{
			authors.add(authorName);
			System.out.println("Author " + authorName + " added to " + this.getTitle() + " author list.");
		}
	}
	
	public void removeAuthor(String authorName)
	{
		if (!authors.remove(authorName))
		{
			System.out.println("No author found to remove.");
		}
		else
		{
			System.out.println("Author " + authorName + " removed from " + this.getTitle() + " author list.");
		}
	}
	
}
