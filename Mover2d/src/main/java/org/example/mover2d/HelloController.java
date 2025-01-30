package org.example.mover2d;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private VBox root;
    private boolean moveBackward=false;
    private boolean moveForward=false;
    private boolean moveDown=false;
    private boolean moveUp=false;
    @FXML
    private Circle player;
    @FXML
    private Pane bounds;

    private double xLim;
    private double yLim;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    private void movementHandler(KeyEvent keyEvent) {
        System.out.println("gamer");
        if (keyEvent.getCode() == KeyCode.A) moveBackward=true;
        if (keyEvent.getCode() == KeyCode.D) moveForward=true;
        if (keyEvent.getCode() == KeyCode.S) moveDown=true;
        if (keyEvent.getCode() == KeyCode.W) moveUp=true;
    }

    private void stop(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.D) moveForward=false;
        if (keyEvent.getCode() == KeyCode.A) moveBackward=false;
        if (keyEvent.getCode() == KeyCode.S) moveDown=false;
        if (keyEvent.getCode() == KeyCode.W) moveUp=false;
    }

    private void moveRouter() {
        moveRouterX();
        moveRouterY();
    }

    private void moveRouterX() {
        double currentXPos = player.getLayoutX();
        double currentYPos = player.getLayoutY();

        double diagonalLenth = Math.sin(Math.sqrt(2)/2);

        if (moveForward && !moveBackward) {
            movePlayer(currentXPos+1, currentYPos);
        }
        else if (!moveForward && moveBackward) {
            movePlayer(currentXPos-1, currentYPos);
        }
    }

    private void moveRouterY() {
        double currentYPos = player.getLayoutY();
        double currentXPos = player.getLayoutX();

        double diagonalLenth = Math.sin(Math.sqrt(2)/2);

        if (!moveUp && moveDown) {
            movePlayer(currentXPos, currentYPos+1);
        }
        else if (moveUp && !moveDown) {
            movePlayer(currentXPos, currentYPos-1);
        }
    }

    private void movePlayer(double x, double y) {
        if (isLegal(x,y)) {
            player.setLayoutX(x);
            player.setLayoutY(y);
        }
    }

    private boolean isLegal(double x, double y) {
        return x <= xLim && y <= yLim;
    }

    public void initialize() {
        Timeline tickTimeline = new Timeline(new KeyFrame(Duration.millis(7), e -> moveRouter()));
        tickTimeline.setCycleCount(Animation.INDEFINITE);
        tickTimeline.play();

        root.setOnKeyPressed(this::movementHandler);
        root.setOnKeyReleased(this::stop);

        xLim = bounds.getPrefWidth();
        yLim = bounds.getPrefHeight();
    }
}
