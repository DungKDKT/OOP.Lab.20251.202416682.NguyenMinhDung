package hust.soict.dsai.test.store.StoreTest;

import hust.soict.dsai.aims.disk.DigitalVideoDisk.DigitalVideoDisk;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisk dvd1 = new DigitalVideoDisk("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisk dvd2 = new DigitalVideoDisk("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisk dvd3 = new DigitalVideoDisk("Aladin", "Animation", 18.99f);

        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        System.out.println("\nStore inventory after adding DVDs:");
        store.printStore();

        store.removeDVD(dvd2);

        System.out.println("\nStore inventory after removing one DVD:");
        store.printStore();

        store.removeDVD(dvd2);
    }
}
