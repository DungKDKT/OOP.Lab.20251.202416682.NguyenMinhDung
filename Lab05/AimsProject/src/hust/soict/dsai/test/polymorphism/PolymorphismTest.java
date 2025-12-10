package hust.soict.dsai.test.polymorphism;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class PolymorphismTest {
	public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Various", 0, 15.99f, "Queen");
        cd.addTrack(new Track("Bohemian Rhapsody", 6));
        cd.addTrack(new Track("We Will Rock You", 2));

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allen", 87, 19.95f);

        List<String> authors = new ArrayList<String>();
        authors.add("J.K. Rowling");
        Book book = new Book("Harry Potter", "Fantasy", 29.99f, authors);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        System.out.println("=== Polymorphism Demo: toString() ===\n");
        for (Media m : mediae) {
            System.out.println(m.toString());
            System.out.println();
        }
    }
}
