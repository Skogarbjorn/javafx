package org.example.verkefni2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import vinnsla.Strengir;

public class StrengirController {
    @FXML
    private Label numberOfInstances;
    @FXML
    private TextArea inputText;
    @FXML
    private TextField searchString;
    @FXML
    private Label wordCount;

    private Strengir currentSave;

    /**
     * Vistar streng í TextArea inn í nýtt Strengir object og gefur
     * error message ef reynt er að vista ekkert
     */
    @FXML
    private void onVistaButtonClick() {
        try {
            currentSave = new Strengir();
            currentSave.saveText(inputText.getText());
        } catch (NullPointerException ex) {
            alertMessage(Alert.AlertType.ERROR, "Enginn texti", "Vinsamlegast skrifið í stóra kassann.");
        }
    }

    /**
     * Leitar að TextField texta í Strengir object, currentSave, og skrifar
     * staðsetningu í numberOfInstances Label á formi char position.
     * Gefur error message ef enginn texti er vistaður
     */
    @FXML
    private void onLeitaButtonClick() {
        try {
            int searchPos = currentSave.search(searchString.getText());
            if (searchPos == -1) {
                numberOfInstances.setText("Ekki fundið");
            } else {
                numberOfInstances.setText("CharPos: " + searchPos);
            }
        } catch (NullPointerException ex) {
            numberOfInstances.setText("-");
            alertMessage(Alert.AlertType.ERROR, "Enginn texti", "Vinsamlegast skrifið í kassana og vistið");
        }
    }

    /**
     * Telur fjölda orða í Stregir object, currentSave, og skrifar
     * niðurstöðu í Label wordCount.
     * Gefur error message ef enginn texti er vistaður
     */
    @FXML
    private void onCountButtonClick() {
        try {
            int count = currentSave.count();
            wordCount.setText(String.valueOf(count));
        } catch (NullPointerException ex) {
            alertMessage(Alert.AlertType.ERROR, "Engin orð", "Vinsamlegast skrifið í stóra kassann og vistið.");
            wordCount.setText("0");
        }
    }

    /**
     * Gefur notanda popup message
     * @param type Týpa popup messagesins t.d. Error
     * @param title Hvað fór úrskeiðis
     * @param message Nánari lýsing á villu
     */
    private static void alertMessage(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}
