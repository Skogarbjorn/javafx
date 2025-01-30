package goldrush.verkefni5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class MenuController {
    private GoldController goldController; // tengja gold controller

    @FXML
    private void handleNewGame() {

    }

    @FXML
    private void handleQuit() {

    }

    @FXML
    private void handleShowHelp() {

    }

    @FXML
    private void handleDifficultyChange(ActionEvent e) {
        RadioMenuItem jeff = (RadioMenuItem) e.getSource();
        goldController.setDifficulty(Integer.parseInt(jeff.getId()));

    }


    public void setGoldController(GoldController goldController) {
        this.goldController = goldController;
        System.out.println(goldController);
    }
}
