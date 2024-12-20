package lab05.GUIProject.hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraserradiobutton;

    @FXML
    private RadioButton penradiobutton;

    @FXML
    private ToggleGroup toolToggleGroup;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color color = Color.BLACK;
        double paneWith = drawingAreaPane.getWidth();
        double paneHeight = drawingAreaPane.getHeight();
        boolean isEraser = eraserradiobutton.isSelected();
        if (isEraser) {
            color = Color.WHITE;
        }
        if (event.getX() >= 0 && event.getX() <= paneHeight && event.getY() >= 0 && event.getY() <= paneWith) {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

}
