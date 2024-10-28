package lab02.AimsProject;

public class DigitalVideoDisc {
    private String title;
    private String director;
    private float cost;
    private int length;
    private String category;
    public String getdirector() {
        return director;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }
    public int getLength() {
        return length;
    }
    public String getTitle() {
        return title;
    }
    public DigitalVideoDisc(String titlle,String category,String director,int length,float cost){
        this.title=titlle;
        this.director=director;
        this.cost=cost;
        this.length=length;
        this.category=category;
    }
    public DigitalVideoDisc(String titlle,String director,float cost,String category){
        this.title=titlle;
        this.director=director;
        this.cost=cost;
        this.category=category;
    }
    public DigitalVideoDisc(String titlle,String category,float cost){
        this.title=titlle;
        this.category=category;
        this.cost=cost;
    }
    public DigitalVideoDisc(String titlle){
        this.title=titlle;
    }
}
