package lab05.Aimsproject.hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import lab05.Aimsproject.hust.soict.hedspi.aims.exception.DupplicatedItemException;
import lab05.Aimsproject.hust.soict.hedspi.aims.exception.NonExistingItemException;
import lab05.Aimsproject.hust.soict.hedspi.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    
    public void addMedia(Media media) throws DupplicatedItemException{
        itemsInStore.add(media);
        System.out.println(media.getTitle()+ " has been added to the store.");
    }

    public void removeMedia(Media media)throws NonExistingItemException {
	    boolean found = false; 
	    for (Media item : itemsInStore) {
	        if (item.equals(media)) {
	        	itemsInStore.remove(item);
	            System.out.println(media.getTitle() + " has been removed from the store.");
	            found = true;
	            break;
	        }
	    }
	    if (!found) System.out.println(media.getTitle() + " is not in the store.");
	}
	public ArrayList<Media> getItemsInStore() {return itemsInStore;}
}
