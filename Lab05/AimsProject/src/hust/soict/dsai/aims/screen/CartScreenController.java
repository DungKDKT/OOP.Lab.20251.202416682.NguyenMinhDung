package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private ToggleGroup filterCategory;
    @FXML 
    private Label lblTotalCost;
    
    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
        System.out.println("Constructor: Cart has " + cart.getItemsOrdered().size() + " items");
    }
    
    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        FilteredList<Media> filteredData = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {showFilteredMedia(filteredData, newValue);
        });
        tblMedia.setItems(filteredData);
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) updateButtonBar(newValue);
                }
            );

            cart.getItemsOrdered().addListener((ListChangeListener<Media>) c -> updateTotalCost());
            updateTotalCost();
    }
    
    void showFilteredMedia(FilteredList<Media> filteredData, String filterString) {
        filteredData.setPredicate(media -> {
            if (filterString == null || filterString.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = filterString.toLowerCase();
            if (radioBtnFilterTitle.isSelected()) {
                if (media.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                }
            } else {
                if (String.valueOf(media.getId()).contains(lowerCaseFilter)) {
                    return true;
                }
            }
            return false;
        });
    }
    
    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Illegal Media Length");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
        }
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cart is Empty");
            alert.setHeaderText(null);
            alert.setContentText("You cannot place an order with an empty cart.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Placed");
            alert.setHeaderText(null);
            alert.setContentText("Your order has been placed successfully!\nTotal cost: " + cart.totalCost() + " $");
            alert.showAndWait();
            cart.getItemsOrdered().clear();
        }
    }

    private void updateTotalCost() {
        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }
}
