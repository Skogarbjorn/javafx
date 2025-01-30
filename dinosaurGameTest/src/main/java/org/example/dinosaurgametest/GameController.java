package org.example.dinosaurgametest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameController {
    @FXML
    private Rectangle fxRectangle;

    private Timeline tickTimeline;

    private void start() {
        if (tickTimeline != null) {
            tickTimeline.playFromStart();
        }
        else {
            tickTimeline = new Timeline(new KeyFrame(Duration.millis(5), e -> tick()));
        }
    }

    private void tick() {
        //moveObstacles();
        //movePlayer();
    }

    public void initialize() {
        start();

        fxRectangle.getScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                //jump();
            }
        });
        fxRectangle.getScene().setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                //stopJump();
            }
        });
    }
}
