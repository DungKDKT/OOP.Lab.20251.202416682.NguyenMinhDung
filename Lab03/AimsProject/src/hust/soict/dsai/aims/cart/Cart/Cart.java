package hust.soict.dsai.aims.cart.Cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.MediaComparator.*;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();  ;

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed.");
        } else {
            System.out.println("The media was not found in the cart.");
        }
    }
    
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }
    
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId() == id) {
                System.out.println("Found: " + itemsOrdered.get(i));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found.");
        }
    }
    
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).equals(title)) {
                System.out.println("Found: " + itemsOrdered.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found.");
        }
    }
    
    public void printCart() {
        System.out.println("************************CART************************");
        System.out.println("Ordered Items:");

        float totalCost = 0;

        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + media);
            totalCost += media.getCost();
        }

        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }
    
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    
    public void sortByTitle() {
        Collections.sort(itemsOrdered, new MediaComparatorByTitleCost());
        System.out.println("Cart sorted by title.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, new MediaComparatorByCostTitle());
        System.out.println("Cart sorted by cost.");
    }
}
