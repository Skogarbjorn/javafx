package org.example.goldrushredo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import vinnsla.Points;

import java.io.IOException;
import java.util.Random;

public class Area extends Pane {
    @FXML
    private Player fxPlayer;
    @FXML
    private Pane fxGoldPane;

    private Timeline goldTimeline;
    private Random random = new Random();

    public Area() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("area.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        fxPlayer.boundsInParentProperty().addListener((observable, oldValue, newValue) -> {
            for (Node n : fxGoldPane.getChildren()) {
                if (fxPlayer.getBoundsInParent().intersects(n.getBoundsInParent())) gotGold((Gold) n);
            }
        });
    }

    public void newGame() {
        clear();
        fxPlayer.setLayoutX(this.getLayoutX()/2 - fxPlayer.getWidth()/2);
        fxPlayer.setLayoutY(this.getLayoutY()/2 - fxPlayer.getHeight()/2);

        Points.reset();

        if (goldTimeline != null) goldTimeline.stop();
        makeGoldTimeline();
    }

    private void makeGoldTimeline() {
        goldTimeline = new Timeline(new KeyFrame(Duration.millis((double) MenuController.diff /30 * 1000), e -> spawnGold()));
    }

    private void spawnGold() {
        Gold gold = new Gold();
        gold.setLayoutX(random.nextInt(500) + 50);
        gold.setLayoutY(random.nextInt(500) + 50);
        fxGoldPane.getChildren().add(gold);
    }

    private void gotGold(Gold g) {
        fxGoldPane.getChildren().removeIf(e -> e == g);
        Points.add();
    }

    private void clear() {
        fxGoldPane.getChildren().removeIf(e -> e.getClass() == Gold.class);
    }
}
