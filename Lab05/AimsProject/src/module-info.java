/**
 * 
 */
/**
 * 
 */
module AimsProject {
	requires java.desktop;
	requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.swing;
    opens hust.soict.dsai.aims.media to javafx.base;
    opens hust.soict.dsai.aims.screen to javafx.fxml;
    
    exports hust.soict.dsai.aims.screen;
}