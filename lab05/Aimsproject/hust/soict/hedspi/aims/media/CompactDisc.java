package lab05.Aimsproject.hust.soict.hedspi.aims.media;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lab05.Aimsproject.hust.soict.hedspi.aims.exception.DupplicatedItemException;
import lab05.Aimsproject.hust.soict.hedspi.aims.exception.NonExistingItemException;
import lab05.Aimsproject.hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks) {
		super(id, title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			throw new PlayerException("ERROR: CD length is non-positive!");
		} else {
			System.out.println("Playing CD: " + this.getTitle());
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			JPanel p = new JPanel();
			JDialog d = new JDialog();
			JLabel l1 = new JLabel("Now playing: " + this.getTitle());
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			l1.setAlignmentX(Component.CENTER_ALIGNMENT);
			d.setTitle("Media Player");
			p.add(Box.createVerticalGlue());
			p.add(l1);
			p.add(Box.createVerticalGlue());
			d.add(p);
			d.setSize(250,100);
			int w = d.getSize().width;
	        int h = d.getSize().height;
	        int x = (dim.width - w) / 2;
	        int y = (dim.height - h) / 2;
			d.setLocation(x, y);
			d.setVisible(true);
			for (Track track: this.tracks) {
				try {
					track.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		}
	}
	
	public void addTrack(Track track) throws DupplicatedItemException {
		if(!tracks.contains(track)) {
			tracks.add(track);
			System.out.println(track+" has been added");
		}
		System.out.println(track+" is already in the track list");
	}
	
	public void removeTrack(Track track) throws NonExistingItemException {
		if(!tracks.contains(track)) {
			System.out.println(track+" is not in the track list");
		}
		else{
			tracks.remove(track);
			System.out.println(track+" has been removed from the track list");
		}
	}
	
	public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String toString() {
		return "ID - "+getId()+ ". CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getArtist() + " - " + getLength() + "s - $" + getCost();
	}
}
