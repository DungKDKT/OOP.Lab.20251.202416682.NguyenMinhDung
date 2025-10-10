package Aim;

public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisk dvd1 = new DigitalVideoDisk("The Lion King", "Animation", "Roger Allers", 87, 20.00f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisk dvd2 = new DigitalVideoDisk("Star Wars", "Science Fiction", "George Lucas", 87, 25.00f);
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisk dvd3 = new DigitalVideoDisk("Aladin", "Animation", 19.00f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
	    System.out.println("\nRemoving 'Star Wars' from cart...");
	    anOrder.removeDigitalVideoDisc(dvd2);
	    System.out.println("Total cost after removal: ");
	    System.out.println(anOrder.totalCost());
	    
	    System.out.println("\nTrying to remove 'Star Wars' again...");
	    anOrder.removeDigitalVideoDisc(dvd2);
	}
}
