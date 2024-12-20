package lab05.Aimsproject.hust.soict.hedspi.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lab05.Aimsproject.hust.soict.hedspi.aims.cart.Cart;
import lab05.Aimsproject.hust.soict.hedspi.aims.exception.CartFullException;
import lab05.Aimsproject.hust.soict.hedspi.aims.media.*;
public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;
    private CartScreenController cartScreen;
    public MediaStore(Media media, Cart cart,CartScreenController cartScreen){
        this.media=media;
        this.cart=cart;
        this.cartScreen=cartScreen;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title=new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost=new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container=new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        ButtonListener btnListener = new ButtonListener();
        JButton addToCartButton = new JButton("Add to cart");
        container.add(addToCartButton);
        addToCartButton.addActionListener(btnListener);
        if(media instanceof Playable){
            JButton playButton = new JButton("Play");
            container.add(playButton);
            playButton.addActionListener(btnListener);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
    }
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String button = e.getActionCommand();
            if (button.equals("Play")){
                showPlayDialog();
            }
            else if (button.equals("Add to cart")){
                try {
                    try {
                        addToCart();
                    } catch (CartFullException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } catch (LimitExceededException e1) {
                    System.err.println("Cannot add media to cart: ");
                }
            }
    }
    private void showPlayDialog(){
        JDialog playDialog = new JDialog();
            playDialog.setTitle("Playing Media");
            playDialog.setSize(300, 150);
            playDialog.setLayout(new FlowLayout());
            JLabel message = new JLabel("Playing: " + media.getTitle());
            playDialog.add(message);
            playDialog.setLocationRelativeTo(null); // Căn giữa màn hình
            playDialog.setVisible(true);
    }
    private void addToCart() throws LimitExceededException, CartFullException{
        cartScreen.updateTotal();
        cart.addMedia(media);
        cartScreen.updateTotal();
    }
    }
}
