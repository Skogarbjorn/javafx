package org.example.canvastesting;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Canvas fxCanvas;
    @FXML
    private ColorPicker fxColorPicker;

    @FXML
    protected void onClear() {
        fxCanvas.getGraphicsContext2D().clearRect(0.0, 0.0, fxCanvas.getWidth(), fxCanvas.getHeight());
    }

    public void initialize() {
        GraphicsContext g = fxCanvas.getGraphicsContext2D();
        g.setStroke(Color.BLACK);
        g.setLineWidth(2);
        g.save();

        fxCanvas.setOnMouseClicked(e -> {
            g.moveTo(e.getX(), e.getY());
            g.beginPath();
        });
        fxCanvas.setOnMouseDragged(e -> {
            g.lineTo(e.getX(), e.getY());
            g.stroke();
        });
        fxCanvas.setOnMouseReleased(e -> {
            g.closePath();
            g.save();
        });

        fxColorPicker.setOnAction(e -> {
            g.setStroke(fxColorPicker.getValue());
        });

        fxCanvas.getParent().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.Z && e.isControlDown()) {
                System.out.println("gamering");
                g.restore();
            }
        });
    }
}
