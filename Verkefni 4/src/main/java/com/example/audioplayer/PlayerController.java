package com.example.audioplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import vinnsla.Askrifandi;
import vinnsla.LagaListar;

import java.util.Optional;


public class PlayerController {


    private VBox vbox;

    @FXML
    private Label InitialCredentials;

    @FXML
    private Button myButton;

    public String getLoginCredentials() {
        return null;
    }

    public void updateLoginCredentials() {
        String text = getLoginCredentials();
        setLoginCredentials(text);
    }

    public void setLoginCredentials(String text) {
        InitialCredentials.setText(text);
    }

    @FXML
    private void onLoginButtonClick() {
        try {
            AskrifandiDialog jeff = new AskrifandiDialog();
            Optional<Askrifandi> result = jeff.showAndWait();
            if (result.isPresent()) {
                Askrifandi askrifandi = result.get();
                setLoginCredentials(askrifandi.getNafn());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onSelectList(ActionEvent event) {
        Button button = (Button) event.getSource();
        int index = GridPane.getColumnIndex(button);

        LagaListar.setListi(index);
        LagaListar.createLists();

        ViewSwitcher.setScene(InitialCredentials.getScene());
        ViewSwitcher.switchTo(View.LISTI);
    }
}
