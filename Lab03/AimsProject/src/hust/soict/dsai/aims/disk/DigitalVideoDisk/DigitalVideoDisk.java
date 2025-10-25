package hust.soict.dsai.aims.disk.DigitalVideoDisk;

public class DigitalVideoDisk {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;	
	private static int nbDigitalVideoDisks = 0;
	private int id;
	public DigitalVideoDisk(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDisks++;
		this.id = nbDigitalVideoDisks;
	}
    public DigitalVideoDisk(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDisks++;
        this.id = nbDigitalVideoDisks;
    }	
	public DigitalVideoDisk(String title, String category, float cost) {
	    this.title = title;
	    this.category = category;
	    this.cost = cost;
        nbDigitalVideoDisks++;
        this.id = nbDigitalVideoDisks;
	}
	public DigitalVideoDisk(String title) {
		this.title = title;
        nbDigitalVideoDisks++;
        this.id = nbDigitalVideoDisks;	
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
		return id;
	}
	public void setTitle(String title) {
	    this.title = title;
	}
	public void setCategory(String category) {
	    this.category = category;
	}
	public void setDirector(String director) {
	    this.director = director;
	}
	public void setLength(int length) {
	    this.length = length;
	}
	public void setCost(float cost) {
	    this.cost = cost;
	}
	public String toString() {
	    return "DigitalVideoDisk - ID: " + id 
	        + " | Title: " + title
	        + " | Category: " + category
	        + " | Director: " + director
	        + " | Length: " + length
	        + " | Cost: " + cost + "$";
	}
	public boolean isMatch(String title) {
		return this.title.equals(title);
	}
}
