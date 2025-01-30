package org.example.rotationtest;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class HelloController {
    @FXML
    private Rectangle player;

    @FXML
    protected void onMove(KeyEvent e) {
        if (e.getCode() == KeyCode.D) {
            rotate();
        }
    }

    private void rotate() {
        Rotate rotate = new Rotate();

        rotate.setAngle(20);

        rotate.setPivotX(player.getWidth());
        rotate.setPivotY(player.getHeight());

        player.getTransforms().add(rotate);
    }
}
