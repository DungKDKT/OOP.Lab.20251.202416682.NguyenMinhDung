package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.screen.Playable;

public class DigitalVideoDisc extends Disc implements Playable {
	public DigitalVideoDisc() {
        super();
    }
    
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, 0, cost);  
    }
    
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, null, 0, cost);  
    }
    
    public DigitalVideoDisc(String title) {
        super();
        setTitle(title);
    }
	
    public String toString() {
        return "DigitalVideoDisc - ID: " + getId() 
            + " | Title: " + getTitle()
            + " | Category: " + getCategory()
            + " | Director: " + getDirector()
            + " | Length: " + getLength()
            + " | Cost: " + getCost() + "$";
    }

	@Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("DVD Title: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
