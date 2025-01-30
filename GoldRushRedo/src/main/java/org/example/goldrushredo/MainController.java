package org.example.goldrushredo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import vinnsla.Points;
import vinnsla.Time;

public class MainController {
    @FXML
    private MenuController menuController;
    @FXML
    private Area fxArea;
    @FXML
    private Label fxPoints;
    @FXML
    private Label fxTime;

    private Time time;

    public void newGame() {
        fxArea.newGame();
        time.stop();
        time.start();
    }

    public void stop() {

    }

    public void initialize() {
        menuController.setMain(this);
        fxPoints.textProperty().bind(Points.points.asString());
        time = new Time(this);
    }
}
