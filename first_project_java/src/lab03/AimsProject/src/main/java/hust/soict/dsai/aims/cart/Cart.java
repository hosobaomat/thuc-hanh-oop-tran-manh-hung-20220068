package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
   public static final int MAX_NUMBERS_ORDERED = 20;
   private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
   private int qtyOrdered;

   public void addDigitalVideoDisc(DigitalVideoDisc disc){
      if(qtyOrdered >= 20){
         System.out.println("The cart is full");
      }
      else {
         itemsOrdered[qtyOrdered] = disc;
         qtyOrdered++;
         System.out.println("The disc has been added");
         if(qtyOrdered >= MAX_NUMBERS_ORDERED - 2){
            System.out.println("The cart is almost full");
         }
      }
   }

   // public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
   //    for (DigitalVideoDisc dvd : dvdList) {
   //       this.addDigitalVideoDisc(dvd);
   //    }
   // }

  public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
     for (DigitalVideoDisc dvd : dvds) {
        this.addDigitalVideoDisc(dvd);
     }
  }
  public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
   if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED){
      itemsOrdered[qtyOrdered] = dvd1;
      qtyOrdered++;
      itemsOrdered[qtyOrdered] = dvd2;
      System.out.println(dvd1.getTitle() + " and " + dvd2.getTitle() + " has been added!");
      qtyOrdered++;
   } else System.out.println("Cannot add more DVDs! The cart is almost full.");
}
   public void removeDigitalVideoDisc(DigitalVideoDisc disc){
      boolean foundDisc = false;

      for (int i = 0; i < qtyOrdered; i++) {
         if (itemsOrdered[i] == disc) {
            foundDisc = true;
            for (int j = i; j < qtyOrdered - 1; j++) {
               itemsOrdered[j] = itemsOrdered[j + 1];
            }
            itemsOrdered[qtyOrdered - 1] = null;
            qtyOrdered--;
            System.out.println("The disc has been removed");
            break;
         }
      }

      if (!foundDisc) {
         System.out.println("The disc is not found in the cart");
      }
   }

   public float totalCost(){
      float total = 0;
      for (int i = 0; i < qtyOrdered; i++) {
         total += itemsOrdered[i].getCost();
      }
      return total;
   }

   public void print(){
      System.out.println("***********************CART***********************");
      System.out.println("Ordered Items:");

      float totalCost = 0;

      for(int i = 0;i < qtyOrdered;i++){
         System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
      }
      System.out.printf("Total cost: %.2f $%n", totalCost());
      System.out.println("***************************************************");
   }

   public void searchById(int id){
      for(int i = 0;i < qtyOrdered;i++){
         if(itemsOrdered[i].getId() == id){
            System.out.println(itemsOrdered[i].toString());
            return;
         }
      }
      System.out.println("Not found DVD with Id = " + id);
   }

   public void searchByTitle(String title){
      for(int i = 0;i < qtyOrdered;i++){
         if(itemsOrdered[i].isMatch(title)){
            System.out.println(itemsOrdered[i].toString());
            return;
         }
      }
      System.out.println("Not found DVD with title : " + title);
   }
}

