package hust.soict.cybersec.aims.media;

import hust.soict.cybersec.aims.exception.PlayerException;

import java.util.*;
import java.time.Duration;

public class CompactDisc extends Disc implements Playable
{

	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	// Constructors
	public CompactDisc(String title)
	{
		super(title);
	}

	public CompactDisc(String title, String category, Track... track)
	{
		super(title, category);
		this.addTrack(track);
	}

	public CompactDisc(String title, String category, String artist)
	{
		super(title, category);
		this.artist = artist;
	}

	public CompactDisc(String title, String category, String artist, Track... track)
	{
		super(title, category);
		this.artist = artist;
		this.addTrack(track);
	}

	public CompactDisc(String title, String category, String artist, float cost)
	{
		super(title, category, cost);
		this.artist = artist;
	}

	public CompactDisc(String title, String category, String artist, float cost, Track... track)
	{
		super(title, category, cost);
		this.artist = artist;
		this.addTrack(track);
	}

	// Getters and Setters
	public String getArtist()
	{
		return artist;
	}

	// Add and remove track
	public void addTrack(Track track)
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

	public void addTrack(Track[] trackList)
	{
		for (Track track : trackList)
		{
			addTrack(track);
		}
		System.out.println("All of the listed tracks have been added.");
	}

	public void addTrack(Track track1, Track... trackList)
	{
		addTrack(track1);
		addTrack(trackList);
	}

	public void removeTrack(Track track)
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
				+ " - Artist: " + this.getArtist() + " - Length: " + this.getLength() + " - Track(s): " + this.tracks
				+ " - Cost: " + this.getCost() + "$";
	}

	@Override
	public void play()
	{
		if (this.getLength() <= 0)
		{
			System.out.println("The CD " + this.getTitle() + " cannot be played.");
			return;
		}
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		for (Track track : tracks)
		{
			track.play();
		}
	}

	public String playGUI() throws PlayerException
	{
		StringBuilder output = new StringBuilder(
				"Playing CD: " + this.getTitle() + "\n" + "CD length: " + formatDuration(this.getLength()) + "\n"
						+ "\n");
		for (Track track : tracks)
		{
			output.append(track.playGUI()).append("\n");
		}
		return output.toString();
	}
}
