package org.example.goldrushredo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.RadioMenuItem;

public class MenuController {
    public static int diff;
    private MainController mainController;

    @FXML
    private void onQuit() {
        Dialog<Alert> gamer = new Dialog<>();
        gamer.setTitle("Viltu hætta?");
        gamer.setContentText("Ertu viss um að þú viljir hætta?");
        gamer.showAndWait();
        if (gamer.getResult() != null) {
            System.exit(0);
        }
    }

    @FXML
    private void onStart() {
        mainController.newGame();
    }

    @FXML
    private void onDiff(ActionEvent e) {
        diff = Integer.parseInt(((RadioMenuItem) e.getSource()).getId());
    }

    public void setMain(MainController mainController) {
        this.mainController = mainController;
    }
}
