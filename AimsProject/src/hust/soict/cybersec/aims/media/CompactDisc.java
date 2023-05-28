package hust.soict.cybersec.aims.media;

import java.util.*;

public class CompactDisc extends Disc
{

	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	// Constructors
	public CompactDisc(String title) 
	{
		super(title);
	}
	
	public CompactDisc(String title, String category, String artist)
	{
		super(title, category);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, String artist, float cost)
	{
		super(title, category, cost);
		this.artist = artist;
	}

	// Getters and Setters
	public String getArtist() 
	{
		return artist;
	}

	// Add and remove track
	public void addtrack(Track track)
	{
		if (tracks.contains(track))
		{
			System.out.println("Track already in list.");
		}
		else
		{
			tracks.add(track);
			System.out.println("Track " + track.getTitle() + " added to " + this.getTitle() + " track list.");
		}
	}
		
	public void removetrack(Track track)
	{
		if (!tracks.remove(track))
		{
			System.out.println("No track found to remove.");
		}
		else
		{
			System.out.println("Track " + track.getTitle() + " removed from " + this.getTitle() + " track list.");
		}
	}
	
	// Get length of the track
	public int getLength()
	{
		int length = 0;
		for (Track track : tracks)
		{
			length += track.getLength();
		}
		
		return length;
	}
	
}
