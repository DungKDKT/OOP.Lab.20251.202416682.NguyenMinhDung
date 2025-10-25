package hust.soict.dsai.test.cart.CartTest;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.disk.DigitalVideoDisk.DigitalVideoDisk;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisk dvd1 = new DigitalVideoDisk("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisk(dvd1);

        DigitalVideoDisk dvd2 = new DigitalVideoDisk("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisk(dvd2);

        DigitalVideoDisk dvd3 = new DigitalVideoDisk("Aladin",
                "Animation", 18.99f);
        cart.addDigitalVideoDisk(dvd3);

        cart.printCart();
        
        int searchId = 3;
        boolean foundId = false;
        for (int i = 0; i < cart.getQtyOrdered(); i++) {
        	DigitalVideoDisk disc = cart.getItemsOrdered()[i];
        	if (disc.getId() == searchId) {
        		System.out.println("\nFound by ID " + searchId + ": " + disc);
        		foundId = true;
        		break;
        	}
        }
        if (!foundId) {
        	System.out.println("\nNo DVD found with ID: " + searchId);
        }
        
        String searchTitle = "Aladin";
        boolean foundTitle = false;
        for (int i = 0; i < cart.getQtyOrdered(); i++) {
        	DigitalVideoDisk disc = cart.getItemsOrdered()[i];
        	if (disc.isMatch(searchTitle)) {
        		System.out.println("\nFound by title \"" + searchTitle + "\": " + disc);
        		foundTitle = true;
        	}
        }
        if (!foundTitle) {
        System.out.println("\nNo DVD found with title: " + searchTitle);
        }
    }
}
