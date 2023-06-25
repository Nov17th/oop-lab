package hust.soict.cybersec.aims.media;

import java.time.*;
import java.util.*;

public abstract class Media
{

	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	private int id;
	private String title;
	private String category;
	private float cost;

	private static int nbMedia = 0;

	// Constructors
	public Media(String title)
	{
		this.title = title;
		this.id = ++nbMedia;
	}

	public Media(String title, String category)
	{
		this.title = title;
		this.category = category;
	}

	public Media(String title, String category, float cost)
	{
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = ++nbMedia;
	}

	// Getters and setters
	public int getId()
	{
		return id;
	}

	public String getTitle()
	{
		return title;
	}

	public String getCategory()
	{
		return category;
	}

	public float getCost()
	{
		return cost;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	@Override
	public String toString()
	{
		return "Media: " + this.title + " - ID: " + this.id + " - Category: " + this.category + " - Cost: " + this.cost
				+ "$";
	}

	public boolean isMatch(String title)
	{
		return this.getTitle().toLowerCase().contains(title.toLowerCase());
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;
		if (!(obj instanceof Media))
			return false;
		return ((Media) obj).getTitle().contains(this.getTitle());
	}

	public void play()
	{
		System.out.println("Playing media: " + this.title);
	}

	public String playGUI()
	{
		return "Playing media " + this.title;
	}

	public String formatDuration(int durationInSeconds)
	{
		Duration duration = Duration.ofSeconds(durationInSeconds);
		return String.format("%02d:%02d", duration.toMinutes(),
				duration.minusMinutes(duration.toMinutes()).getSeconds());
	}
}
