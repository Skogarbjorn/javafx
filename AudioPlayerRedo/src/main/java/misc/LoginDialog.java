package misc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import org.example.audioplayerredo.MainApplication;

import java.io.IOException;

public class LoginDialog extends Dialog<String> {
    @FXML
    private TextField fxName;

    public LoginDialog() {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("login-view.fxml"));
        loader.setController(this);
        try {
            setDialogPane(loader.load());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        fxName.requestFocus();

        setResultConverter(e -> {
            if (e.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return fxName.getText();
            }
            return null;
        });
    }
}
