package org.example.dolistviewshavetobeparameterizedinfxml;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GamerDialog extends Dialog<Gamer> {

    public GamerDialog() {
        setContentText("add your gamer");
        setHeaderText("GAMERING");

        DialogPane d = getDialogPane();
        ButtonType[] buttons = {ButtonType.OK, ButtonType.CLOSE};
        for (ButtonType b : buttons) {
            d.getButtonTypes().add(b);
        }

        Label l = new Label("Gamer Thyngd");
        l.setPrefWidth(100);
        TextField t = new TextField();
        t.setPrefWidth(100);
        t.setPromptText("thyngd");
        Label l1 = new Label("Gamer Nafn");
        l1.setPrefWidth(100);
        TextField t1 = new TextField();
        t1.setPrefWidth(100);
        t1.setPromptText("nafn");

        HBox h = new HBox(l, t);
        h.setPrefWidth(300);
        HBox h1 = new HBox(l1, t1);
        h1.setPrefWidth(300);

        VBox v = new VBox(h, h1);
        v.setPrefWidth(300);

        d.getChildren().add(v);

        setResultConverter(e -> (!t.getText().isEmpty() && !t1.getText().isEmpty()) ? new Gamer(Integer.parseInt(t.getText()), t1.getText()) : null);
    }
}
