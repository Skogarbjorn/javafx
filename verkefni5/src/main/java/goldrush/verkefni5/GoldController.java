package goldrush.verkefni5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class GoldController {

    @FXML
    private MenuController menuController; //menu controller tenging

    @FXML
    private Label scoreLabel; // score

    @FXML
    private Label timerLabel; // time

    @FXML
    private Leikbord fxLeikbord; // arena svaedi object?

    private int difficulty;

    @FXML
    public void initialize() {
        menuController.setGoldController(this);
    }

    private void handleMovement(KeyEvent e) { // movement handler fyrir player, breytir stadsettningu +- 10 x/y axis
    }

    public void setDifficulty(int i) {
        difficulty = i;
    }
}
