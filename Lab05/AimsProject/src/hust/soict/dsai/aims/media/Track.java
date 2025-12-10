package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.screen.Playable;

public class Track implements Playable {
	private String title;
	private int length;
	
	public Track() {
	}
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
        this.length = length;
    }
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Track track = (Track) obj;
	    if (this.length != track.length) {
	        return false;
	    }
	    if (this.title == null) {
	        return track.title == null;
	    }
		return this.title.equals(title);
	}
	
	@Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Track Title: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }
}
