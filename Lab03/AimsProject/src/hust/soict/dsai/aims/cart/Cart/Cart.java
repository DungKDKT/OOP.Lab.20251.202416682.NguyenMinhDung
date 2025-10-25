package hust.soict.dsai.aims.cart.Cart;

import hust.soict.dsai.aims.disk.DigitalVideoDisk.DigitalVideoDisk;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisk itemsOrdered[] = new DigitalVideoDisk[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    
    public void addDigitalVideoDisk(DigitalVideoDisk disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
            
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full");
            }
        } else {
            System.out.println("The cart is full");
        }
    }
    
    public void addDigitalVideoDisk(DigitalVideoDisk [] dvdList) {
    	for (DigitalVideoDisk disk : dvdList) {
    		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
    			itemsOrdered[qtyOrdered] = disk;
    			qtyOrdered++;
    			System.out.println("The disk \"" + disk.getTitle() + "\" has been added ");
    		} else {
    			System.out.println("Cart is full.");
    			break;
    		}
    	}
    }
    
    public void addDigitalVideoDisk(DigitalVideoDisk dvd1, DigitalVideoDisk dvd2) {
        addDigitalVideoDisk(dvd1);
        addDigitalVideoDisk(dvd2);
    }
    
    public void removeDigitalVideoDisk(DigitalVideoDisk disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                found = true;
                System.out.println("The disc has been removed");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found in the cart");
        }
    }
    
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found: " + itemsOrdered[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found.");
        }
    }
    
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found: " + itemsOrdered[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found.");
        }
    }
    
    public void printCart() {
        System.out.println("************************CART************************");
        System.out.println("Ordered Items:");

        float totalCost = 0;

        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisk disc = itemsOrdered[i];
            System.out.println((i + 1) + ". DVD - " 
                + disc.getTitle() + " - " 
                + disc.getCategory() + " - " 
                + disc.getDirector() + " - " 
                + disc.getLength() + ": " 
                + disc.getCost() + " $");
            totalCost += disc.getCost();
        }

        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }
    public DigitalVideoDisk[] getItemsOrdered() {
        return itemsOrdered;
    }
    public int getQtyOrdered() {
        return qtyOrdered;
    }
}
