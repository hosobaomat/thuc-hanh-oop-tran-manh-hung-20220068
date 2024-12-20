package lab05.Aimsproject.hust.soict.hedspi.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.event.ActionEvent;
import lab05.Aimsproject.hust.soict.hedspi.aims.cart.Cart;
import lab05.Aimsproject.hust.soict.hedspi.aims.exception.DupplicatedItemException;
import lab05.Aimsproject.hust.soict.hedspi.aims.media.*;
import lab05.Aimsproject.hust.soict.hedspi.aims.store.*;

public class StoreScreen extends JFrame{
    private Store store;
    private Cart cart;
    private CartScreenController cartScreen;
    public StoreScreen(Store store, Cart cart){
        this.cart=cart;
        this.store=store;
        cartScreen=new CartScreenController(cart, store);
        Container cp=getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024,768);
    }
    JPanel createNorth(){
    JPanel north = new JPanel();
    north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
    north.add(createMenuBar());
    north.add(createHeader());
    return north;
    }
    JMenuBar createMenuBar(){
        JMenu menu=new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        ButtonListener btnListener = new ButtonListener();
        JMenuItem addbook = new JMenuItem("Add book");
        smUpdateStore.add(addbook);
        addbook.addActionListener(btnListener);
        JMenuItem addcd = new JMenuItem("Add cd");
        smUpdateStore.add(addcd);
        addcd.addActionListener(btnListener);
        JMenuItem adddvd = new JMenuItem("Add dvd");
        smUpdateStore.add(adddvd);
        adddvd.addActionListener(btnListener);
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        menu.add(new JMenuItem("View Cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
    
    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
        title.setForeground(Color.CYAN);

        JButton cartbutton=new JButton("View Cart");
        cartbutton.setPreferredSize(new Dimension(100,50));
        cartbutton.setMaximumSize(new Dimension(100,50));
        cartbutton.addActionListener(_ -> {
            // Khi nhấn "View Cart", chuyển sang CartScreen
            new CartScreen(cart, store);
            dispose(); // Đóng cửa sổ StoreScreen hiện tại
        });
        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartbutton);
        header.add(Box.createRigidArea(new Dimension(10,10)));

        return header;
    }
    JPanel createCenter(){
        JPanel center=new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        // Giới hạn số lượng phần tử là 9 hoặc kích thước của danh sách
    int displayCount = Math.min(9, mediaInStore.size());

    for (int i = 0; i < displayCount; i++) {
        MediaStore cell = new MediaStore(mediaInStore.get(i),cart,cartScreen);
        center.add(cell);
    }
        return center;
    }
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e){
            String button = e.getActionCommand();
            if (button.equals("Add book")){
            String title = JOptionPane.showInputDialog(this, "Enter book title:");
            String category = JOptionPane.showInputDialog(this, "Enter book category:");
            float cost = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter book cost:"));
            Book book = new Book(store.getItemsInStore().size() + 1, title, category, cost);
            try {
                store.addMedia(book);
            } catch (DupplicatedItemException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            refreshCenter();
            }
            else if (button.equals("Add cd")){
                String title = JOptionPane.showInputDialog(this, "Enter cd title:");
                String category = JOptionPane.showInputDialog(this, "Enter cd category:");
                float cost = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter cd cost:"));
                CompactDisc cd = new CompactDisc(store.getItemsInStore().size() + 1, title, category, cost);
                try {
                    store.addMedia(cd);
                } catch (DupplicatedItemException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                refreshCenter(); 
            }
            else if(button.equals("Add dvd")){
                String title = JOptionPane.showInputDialog(this, "Enter DVD title:");
                String category = JOptionPane.showInputDialog(this, "Enter DVD category:");
                float cost = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter DVD cost:"));
                DigitalVideoDisc dvd = new DigitalVideoDisc(store.getItemsInStore().size() + 1, title, category, cost);
                try {
                    store.addMedia(dvd);
                } catch (DupplicatedItemException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                refreshCenter(); 
            }
    }
    private void refreshCenter() {
        Container cp = getContentPane();
        cp.remove(1); // Xóa panel trung tâm cũ (ở vị trí BorderLayout.CENTER)
        cp.add(createCenter(), BorderLayout.CENTER); // Thêm lại panel trung tâm mới
        cp.revalidate(); // Làm mới bố cục
        cp.repaint(); // Vẽ lại giao diện
    }
}
    public static void main(String[] args) throws Exception{
        Store store =new Store();
        Cart cart=new Cart();
        CompactDisc cd = new CompactDisc(1, "Soledad", "Ballad", 12.5f);
        CompactDisc cd1 = new CompactDisc(2, "Hybrid Theory", "Rock", 15.5f);
        CompactDisc cd2 = new CompactDisc(5, "Back in Black", "Rock", 18.5f);
        DigitalVideoDisc dvd = new DigitalVideoDisc(4, "Final Fantasy X", "Fantasy", 222.22f);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(6, "The Matrix", "Science Fiction", 150.0f);
        Book book = new Book(3, "Operating System Concepts", "ICT", 30f);
        Track track1 = new Track("Wei", 10);
		Track track2 = new Track("Shu", 21);
		Track track3 = new Track("Wu");
        cd1.addTrack(track3);
        cd2.addTrack(track1);
        cd.addTrack(track2);
        store.addMedia(cd);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(dvd);
        store.addMedia(dvd1);
        store.addMedia(book);
        new StoreScreen(store,cart);
    }
}
