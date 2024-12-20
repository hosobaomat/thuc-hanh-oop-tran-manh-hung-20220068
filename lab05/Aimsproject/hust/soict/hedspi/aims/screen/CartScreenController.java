package lab05.Aimsproject.hust.soict.hedspi.aims.screen;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lab05.Aimsproject.hust.soict.hedspi.aims.media.*;
import lab05.Aimsproject.hust.soict.hedspi.aims.store.Store;
import lab05.Aimsproject.hust.soict.hedspi.aims.cart.Cart;
import lab05.Aimsproject.hust.soict.hedspi.aims.exception.NonExistingItemException;
import lab05.Aimsproject.hust.soict.hedspi.aims.exception.PlayerException;

public class CartScreenController {

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    private Cart cart;
    private Store store;

    public CartScreenController(Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private void initialize() {
        if (btnPlay == null) {
            System.out.println("btnPlay is null");
        }
        if (btnRemove == null) {
            System.out.println("btnRemove is null");
        }

        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsInCart());
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                });
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
        tblMedia.setItems(this.cart.getItemsInCart());
        updateTotal();
    }

    private void showFilteredMedia(String filterText) {
        String filterType = "";
        if (radioBtnFilterTitle.isSelected()) {
            filterType = "title";
        } else {
            filterType = "id";
        }
        if (filterText == null || filterText.isEmpty()) {
            tblMedia.setItems(cart.getItemsInCart());
            return;
        }
        ObservableList<Media> filteredMedia = cart.filterMedia(filterText, filterType);
        tblMedia.setItems(filteredMedia);
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            try {
                cart.removeMedia(media);
            } catch (NonExistingItemException e) {
               Alert alert = new Alert(AlertType.ERROR);
			   alert.setTitle("Notification");
                alert.setHeaderText("Failed to remove");
                alert.setContentText("Media not in cart");
                alert.showAndWait();
            }
            String filterText = tfFilter.getText();
            if (filterText == null || filterText.isEmpty()) {
                tblMedia.setItems(cart.getItemsInCart());
                updateTotal();
                return;
            }
            String filtertype = radioBtnFilterTitle.isSelected() ? "title" : "id";
            ObservableList<Media> filteredMedia = cart.filterMedia(filterText, filtertype);
            tblMedia.setItems(filteredMedia);
        } else {
            System.out.println("no media selected to remove");
        }
        updateTotal();
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnRemove.setVisible(false);
            btnPlay.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

    @FXML
    void placeorderbutton(ActionEvent event) {
        cart.getItemsInCart().clear();
        updateTotal();
        tblMedia.setItems(cart.getItemsInCart());
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
                javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText("Thank you!");
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();

    }

    @FXML
    void btnplaypressed(ActionEvent event) {
       Media media = this.tblMedia.getSelectionModel().getSelectedItem();
		try {
			((Playable)media).play();
		} catch (PlayerException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Media Player");
			alert.setHeaderText("ERROR: Media length is non-positive.");
			alert.setContentText("Media cannot be played.");
			alert.showAndWait();
		}
    }

    @FXML
    private Label total;

    public void updateTotal() {
        if (total != null) {
            float totalCost = cart.totalCost();
            total.setText(String.format("Total: $%.2f", totalCost));
        }
    }

    @FXML
    void viewstore(ActionEvent event) {
        StoreScreen storeScreen = new StoreScreen(store, cart);
        storeScreen.setVisible(true);
        updateTotal();
        
    }
}
