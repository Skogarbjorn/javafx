package org.example.bouncingball;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private VBox vbox;
    private int spacing=0;
    private boolean up=true;
    private Timeline timeline;
    private Timeline timeline1;

    private void jump() {
        if (up) up();
        else down();
    }

    private void tick() {
        vbox.requestFocus();
    }

    private void isJump(KeyEvent keyEvent) {
        System.out.println("gamer");
        if (keyEvent.getCode().equals(KeyCode.UP)) {
            timeline1 = new Timeline(new KeyFrame(Duration.millis(10), event -> jump()));
            timeline1.setCycleCount(Timeline.INDEFINITE);
            timeline1.play();
        }
    }

    private void up() {
        if (spacing < 100) vbox.setSpacing(spacing+=5);
        else up = false;
    }

    private void down() {
        if (spacing > 0) vbox.setSpacing(spacing-=5);
        else {
            timeline1.stop();
            up = true;
        }
    }

    public void initialize() {
        timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> tick()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        vbox.setOnKeyPressed(this::isJump);
    }
}
