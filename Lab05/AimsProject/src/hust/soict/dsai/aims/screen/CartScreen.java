package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class CartScreen extends JFrame{
    private Cart cart;
    
    public CartScreen(Cart cart) {
        super();
        this.cart = cart;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static void main(String[] args) {
        Cart cart = new Cart();
        Media dvd1 = new DigitalVideoDisc("DVD1's Title", "category 1", 7.87f);
        Media cd1 = new CompactDisc("CD2's Title", "category 2", 19.21f);
        Media book1 = new Book("Book3's Title", "category 3", 14.61f);
        try {
            cart.addMedia(dvd1);
            cart.addMedia(cd1);
            cart.addMedia(book1);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
        new CartScreen(cart);
    }
}
