package hust.soict.cybersec.aims.media;

public class Track implements Playable
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

	@Override
	public void play() 
	{
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}

	@Override
	public String toString() 
	{
		return "[Track: " + this.getTitle() + " - Length: " + this.getLength() + "]";
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (obj == this) return true;
		if (!(obj instanceof Track)) return false;
		return (((Track) obj).getTitle() == this.getTitle()) && (((Track) obj).getLength() == this.getLength());
	}
	
}
