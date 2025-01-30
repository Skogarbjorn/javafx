package org.example.game;

import game.Routing;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    private Label welcomeText;
    private Routing routing = new Routing();
    @FXML
    private Pane ground;

    @FXML
    protected void onPlayButtonClick() {
        synchronized ();
        play();
        routing.start();
    }

    protected void play() {
    }
}
