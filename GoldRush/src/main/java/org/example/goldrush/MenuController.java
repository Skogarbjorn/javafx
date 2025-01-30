package org.example.goldrush;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioMenuItem;

/**
 * Controller fyrir menu bar
 */
public class MenuController {
    @FXML
    private GoldController goldController;

    private int currentDifficulty = 60;

    /**
     * Höndlar þegar notandi breytir um erfiðleikastig
     * @param event Hvaða erfiðleikastig var valið
     */
    @FXML
    private void onDifficulty(ActionEvent event) {
        RadioMenuItem item = (RadioMenuItem) event.getSource();
        currentDifficulty = Integer.parseInt(item.getId());
    }

    /**
     * Höndlar þegar notandi byrjar nýjan leik
     */
    @FXML
    private void onStart() {
        goldController.startGame();
    }

    /**
     * Höndlar þegar notandi hættir í forritinu
     */
    @FXML
    private void onStop() {
        Alert gamer = new Alert(Alert.AlertType.CONFIRMATION);
        gamer.setContentText("Viltu hætta?");
        gamer.showAndWait();
        if (gamer.getResult() == ButtonType.OK) {
            System.exit(0);
        }
    }

    /**
     * Höndlar þegar notandi biður um hjálp
     */
    @FXML
    private void onHelp() {
        Alert gamer = new Alert(Alert.AlertType.INFORMATION);
        gamer.setTitle("Um leikinn");
        gamer.setHeaderText("Leiðbeiningar");
        gamer.setContentText("Byrjaðu nýjan leik með því að ýta á File -> New Game \n Notið örvatakka til að færa leikmann. \n Færið leikmanninn að gullinu til þess að fá stig!");
        gamer.showAndWait();
    }

    /**
     * Gefur núverandi erfiðleikastig
     * @return erfiðleikastig
     */
    public int getCurrentDifficulty() {
        return currentDifficulty;
    }

    /**
     * Setur goldController
     * @param goldController GoldController
     */
    public void setGoldController(GoldController goldController) {
        this.goldController = goldController;
    }
}
