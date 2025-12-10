package hust.soict.dsai.test.store.StoreTest;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
                "Animation", 18.99f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        System.out.println("\nStore inventory after adding media:");
        store.printStore();

        store.removeMedia(dvd2);

        System.out.println("\nStore inventory after removing one media:");
        store.printStore();

        store.removeMedia(dvd2);
    }
}
