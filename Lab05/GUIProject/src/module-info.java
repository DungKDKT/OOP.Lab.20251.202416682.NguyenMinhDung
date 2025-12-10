/**
 * 
 */
/**
 * 
 */
module GUIProject {
	requires java.desktop;
	requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    
    opens hust.soict.dsai.javafx.fxml to javafx.graphics, javafx.fxml;
}