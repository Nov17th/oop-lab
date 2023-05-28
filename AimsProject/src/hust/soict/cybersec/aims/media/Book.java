package hust.soict.cybersec.aims.media;

import java.util.*;

public class Book 
{

	private int id;
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();
	
	public int getId() 
	{
		return id;
	}

	public String getTitle() 
	{
		return title;
	}

	public String getCategory() 
	{
		return category;
	}

	public float getCost() 
	{
		return cost;
	}

	public Book() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void addAuthor(String authorName)
	{
		if (authors.contains(authorName))
		{
			System.out.println("This author has already been in the list of authors.");
		}
		else
		{
			authors.add(authorName);
			System.out.println("The author has been added into the list of authors.");
		}
	}
	
	public void removeAuthor(String authorName)
	{
		if (!authors.remove(authorName))
		{
			System.out.println("No author has been found to remove.");
		}
		else
		{
			System.out.println("The author has been removed from the list of authors.");
		}
	}
	
}
