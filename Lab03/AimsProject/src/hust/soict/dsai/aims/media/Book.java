package hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
    
    public Book() {
        super();
    }
    public Book(String title, String category, float cost) {
        super(title, category, cost);
        this.authors = new ArrayList<String>();
    }
    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors != null ? new ArrayList<>(authors) : new ArrayList<>();
    }
    
    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    
    public void addAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            System.out.println("Error: Cannot add null or empty author name.");
            return;
        }
        if (authors.contains(authorName)) {
            System.out.println("Author \"" + authorName + "\" is already in the list.");
            return;
        }
        authors.add(authorName);
        System.out.println("Author \"" + authorName + "\" has been added.");
    }
    
    public void removeAuthor(String authorName) {
        if (authorName == null) {
            System.out.println("Error: Cannot remove null author name.");
            return;
        }
        if (authors.remove(authorName)) {
            System.out.println("Author \"" + authorName + "\" has been removed.");
        } else {
            System.out.println("Author \"" + authorName + "\" is not in the list.");
        }
    }
    
    @Override
    public String toString() {
        return "Book - ID: " + getId() 
            + " | Title: " + getTitle()
            + " | Category: " + getCategory()
            + " | Authors: " + authors
            + " | Cost: " + getCost() + "$";
    }
}