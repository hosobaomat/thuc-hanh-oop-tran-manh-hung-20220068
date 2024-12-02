package lab04.Aimsproject.hust.soict.hedspi.aims.media;

public class Track extends CompactDisc implements Playable {
	private String titleTrack;
	private int length;
	
	public Track(int id, String title, String category, float cost, String titleTrack, int length) {
		super(id, title, category, cost);
		this.titleTrack = titleTrack;
		this.length = length;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	public String getTitle() {
		return titleTrack;
	}
	public void setTitle(String title) {
		this.titleTrack = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
}
