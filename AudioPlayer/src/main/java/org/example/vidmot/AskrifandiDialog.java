package org.example.vidmot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import vinnsla.Askrifandi;

import java.io.IOException;

/**
 * Dialog klasi sem skilar Askrifandi hlut
 */
public class AskrifandiDialog extends Dialog<Askrifandi> {
    @FXML
    private TextField username;

    private Askrifandi askrifandi;

    ButtonType okButtonType = ButtonType.OK;
    ButtonType cancelButtonType = ButtonType.CANCEL;

    /**
     * Smiður sem býr til Askrifandi object og bætir við OK og CANCEL tökkum
     */
    public AskrifandiDialog() {
        this.askrifandi = new Askrifandi("");
        DialogPane dialogPane = lesaDialog();
        dialogPane.getButtonTypes().addAll(okButtonType, cancelButtonType);
        this.setDialogPane(dialogPane);
        setResultConverter();
    }


    /**
     * Höndlar þegar notandi ýtir á OK eða CANCEL takka
     */
    private void setResultConverter() {
        this.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                askrifandi.setNafn(username.getText());
                return askrifandi;
            }
            return null;
        });
    }

    /**
     * Les askrifandi-view.fxml
     * @return DialogPane sem er tengt við askrifandi-view.fxml
     */
    private DialogPane lesaDialog() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/audioplayer/askrifandi-view.fxml"));
            DialogPane pane = fxmlLoader.load();
            username = (TextField) fxmlLoader.getNamespace().get("username");
            return pane;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
