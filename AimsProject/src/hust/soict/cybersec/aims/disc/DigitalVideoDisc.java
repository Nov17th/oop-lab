package hust.soict.cybersec.aims.disc;
public class DigitalVideoDisc 
{
	
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	private static int nbDigitalVideoDiscs = 0;
	private int id = 0;

	// Constructors
	public DigitalVideoDisc(String title) 
	{
		super();
		nbDigitalVideoDiscs += 1;
		this.title = title;
		this.id = nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) 
	{
		super();
		nbDigitalVideoDiscs += 1;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) 
	{
		super();
		nbDigitalVideoDiscs += 1;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) 
	{
		super();
		nbDigitalVideoDiscs += 1;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
	}
	
	// Getters and setters
	public String getTitle() 
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getCategory() 
	{
		return category;
	}
	
	public String getDirector() 
	{
		return director;
	}
	
	public int getLength() 
	{
		return length;
	}
	
	public float getCost() 
	{
		return cost;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() 
	{
		return id + ". DVD - " + title + " - " + category + " - " 
				+ director + " - " + length	+ ": " + cost + "$"; 
	}
	
	public boolean isMatch(String title)
	{
		return this.title.toLowerCase().equals(title.toLowerCase());
	}

}
