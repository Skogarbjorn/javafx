package com.example.audioplayer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import vinnsla.Askrifandi;

import java.io.IOException;

public class AskrifandiDialog extends Dialog<Askrifandi> {
    private String GivenName;

    @FXML
    private TextField LoginCredentials;

    private Askrifandi askrifandi;

    ButtonType okButton = ButtonType.OK;
    ButtonType cancelButton = ButtonType.CANCEL;

    public AskrifandiDialog() {
        DialogPane dialogPane = readFXML();
        dialogPane.getButtonTypes().addAll(okButton, cancelButton);
        this.setDialogPane(dialogPane);
        handleResult();
    }

    private void handleResult() {
        this.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                askrifandi = new Askrifandi(LoginCredentials.getText());
                return askrifandi;
            }
            return null;
        });
    }

    public DialogPane readFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/audioplayer/Askrifandi-view.fxml"));
            DialogPane dialogPane = loader.load();
            LoginCredentials = (TextField) loader.getNamespace().get("LoginCredentials");
            return dialogPane;
        } catch (IOException ex) {
            return null;
        }
    }


}