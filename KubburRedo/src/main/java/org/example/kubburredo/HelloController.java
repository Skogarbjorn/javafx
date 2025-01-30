package org.example.kubburredo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import vinnsla.Kubbur;
import vinnsla.Points;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label fxPoints;
    @FXML
    private Label fxStatus;
    @FXML
    private TextField fxInput;
    @FXML
    private GridPane fxGrid;

    private Kubbur kubbur;
    private Points points;

    @FXML
    private void onNumber(ActionEvent e) {
        Button button = (Button) e.getSource();
        int buttonNumber = kubbur.get(button);
        button.setText(Integer.toString(buttonNumber));

        boolean correctGuess = kubbur.correct(buttonNumber);
        if (correctGuess) {
            handleCorrect(button);
        } else points.incorrectGuess();
        fxGrid.setDisable(correctGuess);
    }

    private void handleCorrect(Button button) {
        button.setDisable(true);
        fxInput.setText("");
        points.correctGuess();
    }

    private void cleanGrid() {
        fxGrid.setDisable(false);
        for (Node n : fxGrid.getChildren()) {
            Button button = (Button) n;
            if (button.getText() != null && !button.isDisable()) {
                button.setText("");
            }
        }
    }

    public void initialize() {
        kubbur = new Kubbur();
        points = new Points();
        fxInput.setOnKeyTyped(e -> {
            try {
                kubbur.setCurrentGuess(Integer.parseInt(e.getCharacter()));
            } catch (NumberFormatException ignored) {}
            cleanGrid();
        });

        fxPoints.textProperty().bind(points.getCurrentPoints().asString());

        fxGrid.disabledProperty().addListener((observable -> {
            for (Node n : fxGrid.getChildren()) {
                if (n.isDisable()) return;
            }
            fxStatus.setText("Leik lokið");
            try {
                FinishedDialog gamer = new FinishedDialog();
                gamer.showAndWait();
                if (gamer.getResult() != null) {
                    System.out.println(gamer.getResult());
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }));
    }
}
