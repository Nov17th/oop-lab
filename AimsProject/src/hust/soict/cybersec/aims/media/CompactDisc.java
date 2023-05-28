package hust.soict.cybersec.aims.media;

import java.util.*;

public class CompactDisc extends Disc implements Playable
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

	@Override
	public String toString() 
	{
		return "CD: " + this.getTitle() + " - ID: " + this.getId() + " - Category: " + this.getCategory() 
					+ " - Artist: " + this.getArtist() + " - Length: " + this.getLength() + " - Track(s): " + this.tracks + " - Cost: " + this.getCost() + "$";
	}
	
	@Override
	public void play() 
	{
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		for (Track track : tracks)
		{
			track.play();
		}
	}
	
}
