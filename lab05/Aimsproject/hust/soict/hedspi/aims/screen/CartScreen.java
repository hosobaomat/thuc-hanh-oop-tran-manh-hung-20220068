package lab05.Aimsproject.hust.soict.hedspi.aims.screen;

import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import lab05.Aimsproject.hust.soict.hedspi.aims.cart.Cart;
import lab05.Aimsproject.hust.soict.hedspi.aims.media.*;
import lab05.Aimsproject.hust.soict.hedspi.aims.store.Store;
public class CartScreen extends JFrame {
    private Cart cart1;
    private Store store;
    public CartScreen(Cart cart,Store store){
        super();

        this.cart1=cart;
        this.store=store;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart,store);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            
        });
    }
    public static void main(String[] args) throws LimitExceededException,Exception {
    Cart cart=new Cart();
    Store store=new Store();
    CompactDisc cd1 = new CompactDisc(1, "Soledad", "Ballad", 12.5f);
    DigitalVideoDisc dvd = new DigitalVideoDisc(3, "Final Fantasy X", "Fantasy", 222.22f);
    Book book = new Book(2, "Operating System Concepts", "ICT", 30f);
    Track track1 = new Track("Wei", 10);
    Track track2 = new Track("Shu", 21);
    Track track3 = new Track("Wu");
    cd1.addTrack(track1);
	cd1.addTrack(track2);
    cd1.addTrack(track3);
    store.addMedia(book);
    store.addMedia(dvd);
    store.addMedia(cd1);
    try {
        cart.addMedia(book);
        cart.addMedia(dvd);
        cart.addMedia(cd1);
    } catch (LimitExceededException e) {
        System.err.println("Error adding media to cart: " + e.getMessage());
    }
    new CartScreen(cart,store);

    }
}
