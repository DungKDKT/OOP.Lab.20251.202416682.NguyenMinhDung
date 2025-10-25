package hust.soict.dsai.test.disk.TestPassingParameter;

import hust.soict.dsai.aims.disk.DigitalVideoDisk.DigitalVideoDisk;

public class TestPassingParameter {
	public static void main(String[] args) {
        DigitalVideoDisk jungleDVD = new DigitalVideoDisk("Jungle");
        DigitalVideoDisk cinderellaDVD = new DigitalVideoDisk("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        
        swapBetter(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
    
    public static void swapBetter(DigitalVideoDisk dvd1, DigitalVideoDisk dvd2) {
        String tempTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tempTitle);

        String tempCategory = dvd1.getCategory();
        dvd1.setCategory(dvd2.getCategory());
        dvd2.setCategory(tempCategory);

        String tempDirector = dvd1.getDirector();
        dvd1.setDirector(dvd2.getDirector());
        dvd2.setDirector(tempDirector);

        int tempLength = dvd1.getLength();
        dvd1.setLength(dvd2.getLength());
        dvd2.setLength(tempLength);

        float tempCost = dvd1.getCost();
        dvd1.setCost(dvd2.getCost());
        dvd2.setCost(tempCost);
    }

    public static void changeTitle(DigitalVideoDisk dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisk(oldTitle);
    }
}
