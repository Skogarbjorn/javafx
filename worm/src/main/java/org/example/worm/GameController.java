package org.example.worm;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;
import vinnsla.Klukka;


public class GameController {

    @FXML
    private MenuController menuController;


    @FXML
    private Leikbord leikbord;

    @FXML
    private Label timer;

    @FXML
    private Label score;


    private Klukka klukka;


    private Timeline timeTimeline;

    private Timeline goldTimeline;


    private int difficulty = 35;




    public void newGame() {
        stop();
        makeClock();
        makeGold();
        leikbord.points.set(0);
    }

    private void makeClock() {
        System.out.println(difficulty);
        klukka = new Klukka(difficulty);
        timer.setText(Integer.toString(difficulty));
        timeTimeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            klukka.tick();
            timer.setText(Integer.toString(klukka.getTime()));
        }));
        timeTimeline.setCycleCount(difficulty);
        timeTimeline.setOnFinished(e -> stop());
        timeTimeline.play();
    }
    private void makeGold() {
        goldTimeline = new Timeline(new KeyFrame(Duration.millis(3000), e -> {
            leikbord.makeMoreGold();
        }));
        goldTimeline.setCycleCount(Animation.INDEFINITE);
        goldTimeline.play();
    }

    private void clear() {
        leikbord.clear();
    }
    private void stop() {
        clear();
        if (timeTimeline != null && goldTimeline != null) {
            timeTimeline.stop();
            goldTimeline.stop();
        }
    }
    public void setDifficulty(int i) {
        difficulty = i;
    }

    @FXML
    public void initialize() {
        //menuController.setGameController(this);


        // score.textProperty().bind(leikbord.points.asString());

    }


}