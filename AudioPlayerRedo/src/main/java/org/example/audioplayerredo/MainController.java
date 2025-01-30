package org.example.audioplayerredo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import misc.LoginDialog;
import vinnsla.Lagalistar;

public class MainController {
    @FXML
    private Button fxLogin;
    @FXML
    private Lagalistar fxLagalistar;

    @FXML
    protected void onLogin() {
        LoginDialog gamer = new LoginDialog();
        gamer.showAndWait();
        String result = gamer.getResult();
        if (result != null) {
            fxLogin.setText(result);
            fxLagalistar.setDisable(false);
            ViewSwitcher.setScene(this.fxLogin.getScene());
        }
    }

    public void initialize() {
        fxLagalistar.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            Lagalistar.selected = newValue;
            ViewSwitcher.switchTo(View.ALBUM);
        });
    }
}
