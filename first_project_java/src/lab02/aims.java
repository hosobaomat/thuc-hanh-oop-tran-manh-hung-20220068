package lab02;

public class aims {
    public static void main(String[] args) {
        cart cart = new cart();
        DigitalVideoDisc disc1 = new DigitalVideoDisc("The lion king","Animation","Roger Allers",87,19.95f);
        cart.addDigitalVideoDisc(disc1);
        DigitalVideoDisc disc2 = new DigitalVideoDisc("Star Wars","Science fiction","george lucas",87,24.95f);
        cart.addDigitalVideoDisc(disc2);
        DigitalVideoDisc disc3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
        cart.addDigitalVideoDisc(disc3);
        System.out.println("total cost is: "+ cart.totalCost());
        cart.display();
    }
}
