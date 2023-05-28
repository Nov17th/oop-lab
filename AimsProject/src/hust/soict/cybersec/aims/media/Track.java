package hust.soict.cybersec.aims.media;

public class Track 
{

	private String title;
	private int length;
	
	// Constructors
	public Track(String title, int length) 
	{
		this.title = title;
		this.length = length;
	}

	// Getters and Setters
	public String getTitle() 
	{
		return title;
	}

	public int getLength() 
	{
		return length;
	}
	
}
