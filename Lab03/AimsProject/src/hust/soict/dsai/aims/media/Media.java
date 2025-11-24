package hust.soict.dsai.aims.media;

import java.util.Comparator;

import hust.soict.dsai.aims.MediaComparator.*;

public class Media {
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
	        new MediaComparatorByTitleCost();
	    
	    public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
	        new MediaComparatorByCostTitle();
	
	    
    private String title;
    private String category;
    private float cost;
    private static int nbMedia= 0;
    private int id;
    
    public Media() {
    }
    public Media(String title) {
        this.title = title;
        nbMedia++;
		this.id = nbMedia;
    }
    
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
		this.id = nbMedia;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public float getCost() {
        return cost;
    }
    
    public void setCost(float cost) {
        this.cost = cost;
    }
    
    public int getId() {
		return id;
    }
    public void setId(int id) {
    	this.id = id;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Media media = (Media) obj;
        if (this.title == null) {
            return media.title == null;
        }
		return this.title.equals(title);
	}
}
