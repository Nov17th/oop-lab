package hust.soict.cybersec.aims.media;

public class DigitalVideoDisc extends Disc
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
	
	@Override
	public String toString() 
	{
		return this.getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - " 
				+ this.getDirector() + " - " + this.getLength()	+ ": " + this.getCost() + "$"; 
	}
	
	public boolean isMatch(String title)
	{
		return this.getTitle().toLowerCase().equals(getTitle().toLowerCase());
	}

}
