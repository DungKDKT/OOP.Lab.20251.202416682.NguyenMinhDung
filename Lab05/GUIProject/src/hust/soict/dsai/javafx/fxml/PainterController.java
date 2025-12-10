package hust.soict.dsai.javafx.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class PainterController {
	@FXML
	private Pane drawingAreaPane;
	@FXML
    private RadioButton penRadio;
    @FXML
    private RadioButton eraserRadio;
	@FXML
	void clearButtonPressed(ActionEvent event) {
	    drawingAreaPane.getChildren().clear();
	}
	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		Color inkColor = Color.BLACK;
		if (eraserRadio.isSelected()) {
	        inkColor = Color.WHITE;
	    }
		Circle newCircle = new Circle(event.getX(), event.getY(), 4, inkColor);
	    drawingAreaPane.getChildren().add(newCircle);
	}
}
