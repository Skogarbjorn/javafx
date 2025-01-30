package org.example.kubbur;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import vinnsla.Kubbur;
import vinnsla.Stykki;

public class KubburController {
    private int currentGuess;
    @FXML
    private Label stig;
    @FXML
    private GridPane keypad;
    @FXML
    private Label gameStatus;
    private Kubbur gamer = new Kubbur(3,3);
    private int stigLota;
    private int counter=0;
    IntegerProperty counterProperty = new SimpleIntegerProperty();
    private int totalStig=0;

    /**
     * Byrjunarfall sem býr til binding fyrir fjölda stiga og leik lokið property.
     */
    public void initialize() {
        stig.textProperty().bind(Bindings.createStringBinding(() -> {
            totalStig += stigLota;
            return String.valueOf(totalStig);
        },counterProperty));

        counterProperty.set(counter);

        gameStatus.textProperty().bind(Bindings.createStringBinding(() -> {
            if (counterProperty.get() == gamer.getNumber().length) return "Leik lokið";
            else return "Leikur í gangi";
        },counterProperty));
    }

    /**
     * Bregst við þegar notandi setur nýtt keyEvent inn í TextField input og
     * endurræsir borðið og setur currentGuess sem keyEvent-ið
     * @param keyEvent Takkinn sem notandi ýtti á
     */
    @FXML
    private void onNyTala(KeyEvent keyEvent) {
        try {
            currentGuess = Integer.parseInt(keyEvent.getCharacter());
            stigLota = 5;
            keypad.setDisable(false);
            for (Node i : keypad.getChildren())
                if (!i.isDisable()) {
                    removeMynd((Button) i);
                }
        } catch (NumberFormatException ignored) {}
    }

    /**
     * Bregst við í hvert sinn sem notandi ýtir á einn af tökkunum í GridPane
     * og sýnir mynd af viðeigandi tölu á takkann, tékkar svo hvort notandi
     * hafi giskað rétt og minnkar fáanleg stig ef ekki
     * @param actionEvent Eventið sem valdi fallinu, notað til að fá takkann
     */
    @FXML
    private void onSetjaStykki(ActionEvent actionEvent) {
        Button reitur = (Button) actionEvent.getSource();
        int i = GridPane.getRowIndex(reitur);
        int j = GridPane.getColumnIndex(reitur);
        setjaMynd(gamer.getBordStykki(i, j), reitur);
        if (correctHandler(gamer.getBordStykki(i, j))) reitur.setDisable(true);
        else if (stigLota > 1) stigLota--;
    }


    /**
     * Setur mynd á takka
     * @param stykki Hvaða númer á að setja
     * @param b Hvaða takki á að fá mynd
     */
    @FXML
    private void setjaMynd(Stykki stykki, Button b) {
        b.getStyleClass().removeAll();
        b.getStyleClass().add(stykki.getNafn());
    }


    /**
     * Felur mynd á takka
     * @param b Takkinn
     */
    @FXML
    private void removeMynd(Button b) {
        b.getStyleClass().setAll("button");
    }

    /**
     * Athugar hvort notandi hefur giskað rétt
     * @param stykki Talan á bak við takkann
     * @return Rétt eða ekki
     */
    private boolean correctHandler(Stykki stykki) {
        if (stykki.getTala()==currentGuess) {
            stig();
            keypad.setDisable(true);
            counterProperty.set(++counter);
            return true;
        }
        return false;
    }

    /**
     * Nær í uppfærð heildarstig frá vinnslu
     */
    private void stig() {
        totalStig = Integer.parseInt(stig.getText());
    }
}
