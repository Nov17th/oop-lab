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

	public Book(String title, String category, String... author)
	{
		super(title, category);
		this.addAuthor(author);
	}

	public Book(String title, String category, float cost)
	{
		super(title, category, cost);
	}

	public Book(String title, String category, float cost, String... author)
	{
		super(title, category, cost);
		this.addAuthor(author);
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

	public void addAuthor(String[] authorList)
	{
		for (String author : authorList)
		{
			addAuthor(author);
		}
		System.out.println("All of the listed authors have been added for the book.");
	}

	public void addAuthor(String authorName1, String... authorList)
	{
		addAuthor(authorName1);
		addAuthor(authorList);
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

	@Override
	public String toString()
	{
		return "Book: " + this.getTitle() + " - ID: " + this.getId() + " - Author(s): " + this.authors + " - Category: "
				+ this.getCategory() + " - Cost: " + this.getCost() + "$";
	}

}
