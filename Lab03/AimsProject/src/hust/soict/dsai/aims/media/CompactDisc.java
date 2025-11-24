package hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

import hust.soict.dsai.aims.screen.Manager.Playable;


public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    
    public CompactDisc() {
        super();
    }
    
    public CompactDisc(String title, String category, String director, int length, float cost, String artist, List<Track> tracks) {
        super(title, category, director, length, cost);
        this.artist = artist;
        this.tracks = tracks != null ? new ArrayList<>(tracks) : new ArrayList<>();
    }
    
    public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }
    
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
		this.artist = artist;
	}

	public void addTrack(Track track) {
        if (track == null) {
            System.out.println("Error: Cannot add null track.");
            return;
        }
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" is already in the CD.");
            return;
        }
        tracks.add(track);
        System.out.println("Track \"" + track.getTitle() + "\" has been added to the CD.");
    }
    
    public void removeTrack(Track track) {
        if (track == null) {
            System.out.println("Error: Cannot remove null track.");
            return;
        }
        if (tracks.remove(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" has been removed from the CD.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" is not in the CD.");
        }
    }
    
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    @Override
    public String toString() {
        return "CompactDisc - ID: " + getId() 
            + " | Title: " + getTitle()
            + " | Category: " + getCategory()
            + " | Artist: " + artist
            + " | Director: " + getDirector()
            + " | Total Tracks: " + tracks.size()
            + " | Total Length: " + getLength()
            + " | Cost: " + getCost() + "$";
    }
    
    @Override
    public void play() {
        System.out.println("CD Title: " + getTitle());
        System.out.println("Artist: " + this.artist);
        System.out.println("Total tracks: " + tracks.size());
        System.out.println("Total length: " + this.getLength() + " minutes");
        for (Track track : tracks) {
            track.play();
        }
    }
}
