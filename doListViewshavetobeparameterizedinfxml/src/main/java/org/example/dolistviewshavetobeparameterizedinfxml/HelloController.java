package org.example.dolistviewshavetobeparameterizedinfxml;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Optional;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private GamerList listi;

    @FXML
    protected void onHelloButtonClick() {
        GamerDialog g = new GamerDialog();
        Optional<Gamer> o = g.showAndWait();
        o.ifPresentOrElse(gamer -> listi.addGamer(gamer), () -> {});
    }
}
