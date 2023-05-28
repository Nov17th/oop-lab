package hust.soict.cybersec.aims.media;

public class DigitalVideoDisc extends Disc implements Playable
{
	
	// Constructors
	public DigitalVideoDisc(String title) 
	{
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category)
	{
		super(title, category);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) 
	{
		super(title, category, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) 
	{
		super(title, category, director, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) 
	{
		super(title, category, director, length, cost);
	}
	
	public boolean isMatch(String title)
	{
		return this.getTitle().toLowerCase().equals(getTitle().toLowerCase());
	}
	
	@Override
	public String toString() 
	{
		return "DVD: " + this.getTitle() + " - ID: " + this.getId() + " - Category: " + this.getCategory() 
					+ " - Director: " + this.getDirector() + " - Length: " + this.getLength() + " - Cost: " + this.getCost() + "$";
	}

	@Override
	public void play() 
	{
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());		
	}

	
}
