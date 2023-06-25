package hust.soict.cybersec.aims.media;

import hust.soict.cybersec.aims.exception.PlayerException;

import java.time.Duration;

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
		if (this.getLength() <= 0)
		{
			System.out.println("The track " + this.getTitle() + " cannot be played.");
			return;
		}
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}

	public String formatDuration(int durationInSeconds)
	{
		Duration duration = Duration.ofSeconds(durationInSeconds);
		return String.format("%02d:%02d", duration.toMinutes(),
				duration.minusMinutes(duration.toMinutes()).getSeconds());
	}

	public String playGUI() throws PlayerException
	{
		if (this.getLength() > 0)
		{
			return "Playing track: " + this.getTitle() + "\n" + "Track length: " + formatDuration(this.getLength());
		}
		else
		{
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
	}

	@Override
	public String toString()
	{
		return "[Track: " + this.getTitle() + " - Length: " + this.getLength() + "]";
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;
		if (!(obj instanceof Track))
			return false;
		return (((Track) obj).getTitle() == this.getTitle()) && (((Track) obj).getLength() == this.getLength());
	}

}
