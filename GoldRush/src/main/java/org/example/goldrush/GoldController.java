package org.example.goldrush;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import vinnsla.Klukka;
import java.util.HashMap;


/**
 * Stjórnar gold-rush-view.fxml
 */
public class GoldController {
    @FXML
    private MenuController menuController;

    @FXML
    private Leikbord fxLeikbord;

    private Klukka klukka;

    @FXML
    private Label timi;

    @FXML
    private Label points;

    private final HashMap<KeyCode, Stefna> map = new HashMap<>();

    private Timeline timeline;

    private Timeline goldTimeline;

    /**
     * Bætir við virkni fyrir örvatakka
     */
    private void arrowKeys() {
        map.put(KeyCode.UP, Stefna.UP);
        map.put(KeyCode.DOWN, Stefna.DOWN);
        map.put(KeyCode.LEFT, Stefna.LEFT);
        map.put(KeyCode.RIGHT, Stefna.RIGHT);
        fxLeikbord.requestFocus();
        fxLeikbord.addEventFilter(KeyEvent.ANY, e -> {
            fxLeikbord.stefna(map.get(e.getCode()));
        });
    }

    /**
     * Byrjar klukku með tíma miðað við erfiðleikastig valið
     */
    private void initializeClock() {
        klukka = new Klukka(menuController.getCurrentDifficulty());
        timi.setText(Integer.toString(klukka.getTime()));
        KeyFrame keyFrame = new KeyFrame(new Duration(1000), e -> {
            klukka.tic();
            timi.setText(Integer.toString(klukka.getTime()));
        });

        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(menuController.getCurrentDifficulty());
        timeline.setOnFinished(this::handleStop);
        timeline.play();
    }

    /**
     * Stoppar leik
     * @param actionEvent Klukka búin
     */
    private void handleStop(ActionEvent actionEvent) {
        timeline.stop();
        goldTimeline.stop();
        fxLeikbord.clean();
    }

    /**
     * Byrjar nýjan leik
     */
    public void startGame() {
        if (goldTimeline != null) goldTimeline.stop();
        if (timeline != null) timeline.stop();
        fxLeikbord.reset();

        KeyFrame k = new KeyFrame(new Duration(1000*menuController.getCurrentDifficulty()/30), e -> fxLeikbord.moreGold());
        goldTimeline = new Timeline(k);
        goldTimeline.setCycleCount(Animation.INDEFINITE);
        goldTimeline.play();
        initializeClock();
        fxLeikbord.requestFocus();
    }

    /**
     * Initialize fall
     */
    public void initialize() {
        arrowKeys();
        menuController.setGoldController(this);
        points.textProperty().bind(fxLeikbord.points.asString());
    }
}
