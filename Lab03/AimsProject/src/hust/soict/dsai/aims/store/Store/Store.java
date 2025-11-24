package hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import javax.swing.*;

import hust.soict.dsai.aims.media.Media;

public class Store extends JPanel {
	private static final long serialVersionUID = 1L;
    public static final int MAX_NUMBERS_IN_STORE = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_NUMBERS_IN_STORE) {
            itemsInStore.add(media);
            System.out.println("Media added to store: " + media.getTitle());
        } else {
            System.out.println("The store is full. Cannot add more media.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media removed from store: " + media.getTitle());
        } else {
            System.out.println("Media not found in store: " + media.getTitle());
        }
    }
    
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void printStore() {
        System.out.println("*******************STORE*******************");
        System.out.println("Available items:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i));
        }
        System.out.println("*******************************************");
    }
}
