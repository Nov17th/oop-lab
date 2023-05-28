package hust.soict.cybersec.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>
{

	@Override
	public int compare(Media o1, Media o2) 
	{
		return Comparator.comparing(Media::getTitle).
				thenComparing(Media::getCost, Comparator.reverseOrder()).compare(o1, o2);
	}

}
