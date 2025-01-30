package org.example.strengirredo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;
import vinnsla.Strengir;

public class StrengirController {
    @FXML
    private Label leitaLabel;
    @FXML
    private Label teljaLabel;
    @FXML
    private TextField searchField;
    @FXML
    private TextArea inputArea;
    @FXML
    private Button vistaButton;

    private Strengir strengir;

    @FXML
    protected void onLeita() {
        try {
            leitaLabel.setText(strengir.leita(searchField.getText()));
        } catch (NullPointerException ex) {
            newAlert("Vistaðu streng fyrst og sláðu inn leitarorð");
        }
    }

    @FXML
    protected void onTelja() {
        try {
            teljaLabel.setText(strengir.telja());
        } catch (NullPointerException ex) {
            newAlert("Vistaðu streng fyrst");
        }
    }

    @FXML
    protected void onVista() {
        if (inputArea.getText() != null) {
            strengir.setString(inputArea.getText());
            vistaButton.setText("Vistað!");
            Timeline vistaTimeline = new Timeline(new KeyFrame(Duration.millis(1500), e -> {}));
            vistaTimeline.setCycleCount(0);
            vistaTimeline.setOnFinished(e -> {vistaButton.setText("Vista");});
            vistaTimeline.play();
        }
    }

    private void newAlert(String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(alertMessage);
        alert.setHeaderText("Villa");
        alert.setTitle("Villa");
        alert.showAndWait();
    }

    public void initialize() {
        strengir = new Strengir();
    }
}
