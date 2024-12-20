package lab05.Aimsproject.hust.soict.hedspi.aims.media;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Box;
import lab05.Aimsproject.hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc {
	public DigitalVideoDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		} else {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			JPanel p = new JPanel();
			JDialog d = new JDialog();
			JLabel l1 = new JLabel("Now playing: " + this.getTitle());
			JLabel l2 = new JLabel("DVD length: " + this.getLength());
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			l1.setAlignmentX(Component.CENTER_ALIGNMENT);
			l2.setAlignmentX(Component.CENTER_ALIGNMENT);
			d.setTitle("Media Player");
			p.add(Box.createVerticalGlue());
			p.add(l1);
			p.add(l2);
			p.add(Box.createVerticalGlue());
			d.add(p);
			d.setSize(250,100);
			int w = d.getSize().width;
	        int h = d.getSize().height;
	        int x = (dim.width - w) / 2;
	        int y = (dim.height - h) / 2;
			d.setLocation(x, y);
			d.setVisible(true);
		}
	}
	
	//toString method
	public String toString() {
		return "ID - " +getId()+ ". DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + "s - $" + getCost();
	}
}
