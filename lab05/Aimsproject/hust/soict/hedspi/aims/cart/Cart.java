package lab05.Aimsproject.hust.soict.hedspi.aims.cart;


import javax.naming.LimitExceededException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lab05.Aimsproject.hust.soict.hedspi.aims.exception.CartFullException;
import lab05.Aimsproject.hust.soict.hedspi.aims.exception.NonExistingItemException;
import lab05.Aimsproject.hust.soict.hedspi.aims.media.Media;

public class Cart {
    private final int MAX_NUMBER_ORDERED = 20;
	private float totalCost=0;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public void addMedia(Media media) throws LimitExceededException,CartFullException {
		if (itemsOrdered.size()<MAX_NUMBER_ORDERED) {
			itemsOrdered.add(media);
            totalCost+=media.getCost();
			System.out.println(media.getTitle()+" has been added to the cart.");
		}
		else {
			throw new LimitExceededException("Error: the number of "+ "meida has reached its limit");
		};
	}
	
	public void removeMedia(Media media)throws NonExistingItemException {
		boolean removed = itemsOrdered.remove(media);
		if (removed) {
			System.out.println(media.getTitle() + " has been removed from the cart.");
			totalCost-=media.getCost();
			
		} else {
			System.out.println(media.getTitle() + " is not in the cart.");
		}
	}
	
	
	public ObservableList<Media> getItemsInCart(){
		return this.itemsOrdered;
	} 
	public ObservableList<Media> filterMedia(String filterText,String filterType){
		ObservableList<Media> filteredList = FXCollections.observableArrayList();
		for(Media media : itemsOrdered){
			if(filterType.equalsIgnoreCase("title")&& media.getTitle().toLowerCase().contains(filterText.toLowerCase())){
				filteredList.add(media);
			}
			else if(filterType.equalsIgnoreCase("id")){
				try{
					int filterId=Integer.parseInt(filterText);
					if(media.getId()==filterId){
						filteredList.add(media);
					}
				}
				catch(NumberFormatException e){
					System.out.println("Invalid ID format"+filterText);
				}
			}
		}
		return filteredList;
	}
	
	//Get total cost
	public float totalCost() {
		float totel=0;
		for(Media i:itemsOrdered){
			totel+=i.getCost();
		}
		return totel;
    }

	//Print cart method
	public void printCart() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0 ; i < itemsOrdered.size(); i++) {
			System.out.println((i+1) + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: $" + totalCost());
		System.out.println("***************************************************");
	}

	//Search for DVDs in the cart by ID and display them
	//Notify to user if no match is found
	public void searchID(int id){
		boolean found = false;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				found = true;
				System.out.println("DVD found: ");
				System.out.println(itemsOrdered.get(i).toString());
				break;
			}
		}
		if (!found) System.out.println("No match is found!");
	}

	//Search for DVDs in the cart by title and display them
	//Notify to user if no match is found
	public void searchTitle(String title){
		boolean found = false;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				found = true;
				System.out.println("DVD found: ");
				System.out.println(itemsOrdered.get(i).toString());
				break;
			}
		}
		if (!found) System.out.println("No match is found!");
	}
}
