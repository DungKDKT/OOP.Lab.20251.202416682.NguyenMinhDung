package hust.soict.dsai.aims.Aims;

import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.store.Store.Store;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.Playable;
import hust.soict.dsai.aims.exception.*;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        initializeStore();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        
        scanner.close();
    }
    
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    
    public static void viewStore() {
        store.printStore();
        storeMenu();
    }
    
    public static void storeMenu() {
        int choice;
        do {
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    
    public static void mediaDetailsMenu(Media media) {
        int choice;
        do {
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    try {
                        cart.addMedia(media);
                        System.out.println("Number of items in cart: " + cart.getItemsOrdered().size());
                    } catch (LimitExceededException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    if (media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (PlayerException e) {
                            System.err.println(e.getMessage());
                        }
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    
    public static void seeMediaDetails() {
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();
        
        Media media = findMediaInStore(title);
        if (media != null) {
            System.out.println(media);
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found in store.");
        }
    }
    
    public static void addMediaToCart() {
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();
        
        Media media = findMediaInStore(title);
        if (media != null) {
            try {
                cart.addMedia(media);
                System.out.println("Number of items in cart: " + cart.getItemsOrdered().size());
            } catch (LimitExceededException e) {
                 System.err.println(e.getMessage());
            }
        } else {
            System.out.println("Media not found in store.");
        }
    }
    
    public static void playMedia() {
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();
        
        Media media = findMediaInStore(title);
        if (media != null) {
            if (media instanceof Playable) {
                try {
                    ((Playable) media).play();
                } catch (PlayerException e) {
                    System.err.println(e.getMessage());
                }
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("Media not found in store.");
        }
    }
    
    public static void updateStore() {
        System.out.println("\nUpdate Store:");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("Please choose a number: 0-1-2");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.println("Enter media title: ");
                String title = scanner.nextLine();
                System.out.println("Enter category: ");
                String category = scanner.nextLine();
                System.out.println("Enter cost: ");
                float cost = scanner.nextFloat();
                scanner.nextLine();
                
                Media newMedia = new Media(title, category, cost); 
                store.addMedia(newMedia);
                break;
            case 2:
                System.out.println("Enter the title of media to remove: ");
                String removeTitle = scanner.nextLine();
                Media mediaToRemove = findMediaInStore(removeTitle);
                if (mediaToRemove != null) {
                    store.removeMedia(mediaToRemove);
                } else {
                    System.out.println("Media not found in store.");
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    public static void seeCurrentCart() {
        cart.printCart();
        cartMenu();
    }
    
    public static void cartMenu() {
        int choice;
        do {
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    placeOrder();
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    
    public static void filterCart() {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.println("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                cart.searchById(id);
                break;
            case 2:
                System.out.println("Enter title: ");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    public static void sortCart() {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                cart.sortByTitle();
                cart.printCart();
                break;
            case 2:
                cart.sortByCost();
                cart.printCart();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    public static void removeMediaFromCart() {
        System.out.println("Enter the title of media to remove: ");
        String title = scanner.nextLine();
        
        Media media = findMediaInCart(title);
        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found in cart.");
        }
    }
    
    public static void playMediaFromCart() {
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();
        
        Media media = findMediaInCart(title);
        if (media != null) {
            if (media instanceof Playable) {
                try {
                    ((Playable) media).play();
                } catch (PlayerException e) {
                    System.err.println(e.getMessage());
                }
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("Media not found in cart.");
        }
    }
    
    public static void placeOrder() {
        System.out.println("An order is created!");
        System.out.println("The cart is now empty.");
        cart = new Cart(); 
    }

    private static Media findMediaInStore(String title) {
        for (Media media : store.getItemsInStore()) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    
    private static Media findMediaInCart(String title) {
        for (Media media : cart.getItemsOrdered()) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    private static void initializeStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
    }

}
