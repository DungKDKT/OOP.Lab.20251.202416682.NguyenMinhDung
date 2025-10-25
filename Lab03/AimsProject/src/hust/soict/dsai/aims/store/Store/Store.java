package hust.soict.dsai.aims.store.Store;

import hust.soict.dsai.aims.disk.DigitalVideoDisk.DigitalVideoDisk;

public class Store {
    public static final int MAX_NUMBERS_IN_STORE = 100;
    private DigitalVideoDisk[] itemsInStore = new DigitalVideoDisk[MAX_NUMBERS_IN_STORE];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisk dvd) {
        if (qtyInStore < MAX_NUMBERS_IN_STORE) {
            itemsInStore[qtyInStore++] = dvd;
            System.out.println("DVD added to store: " + dvd.getTitle());
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisk dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                found = true;
                // Shift the remaining DVDs left
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[--qtyInStore] = null;
                System.out.println("DVD removed from store: " + dvd.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("DVD not found in store: " + dvd.getTitle());
        }
    }

    public void printStore() {
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println(itemsInStore[i]);
        }
    }
}
