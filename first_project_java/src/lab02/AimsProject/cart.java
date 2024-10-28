package lab02.AimsProject;
import java.util.ArrayList;
public class cart {
    private int qtyOrdered=0;
    public static final int MAX_NUMBER_ORDERED =20;
    private ArrayList<DigitalVideoDisc> items = new ArrayList<>();
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered<MAX_NUMBER_ORDERED){
            items.add(disc);
            qtyOrdered++;
            System.out.println("the disc has been added.");
        }
        else{
            System.out.println("the cart is full");
        }
    } 
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        if(items.remove(disc)){
            qtyOrdered--;
            System.out.println("the disc has been removed");
        }
        else{
            System.out.println("the disc is not found");
        }
    }
    public float totalCost() {
        float total=0;
        for(DigitalVideoDisc disc : items){
            total+=disc.getCost();
        }    
        return total;
    }
    public void display(){
        System.out.println("Items in cart:");
        for(DigitalVideoDisc disc:items){
            System.out.println(disc.getTitle() + " | " + disc.getCategory() +" | " + disc.getdirector() + " | " + disc.getLength() + " | $" + disc.getCost());
        }
    }
}