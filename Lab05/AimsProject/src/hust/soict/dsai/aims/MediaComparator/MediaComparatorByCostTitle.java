package hust.soict.dsai.aims.MediaComparator;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media> {
	@Override
    public int compare(Media m1, Media m2) {
        return Comparator.comparing(Media::getCost).reversed().thenComparing(Media::getTitle).compare(m1, m2);
    }
}
