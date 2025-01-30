package org.example.dolistviewshavetobeparameterizedinfxml;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

public class GamerList extends ListView<Gamer> {
    public GamerList() {
        setItems(FXCollections.observableArrayList());
    }

    public void addGamer(Gamer gamer) {
        if (!getItems().contains(gamer)) getItems().add(gamer);
    }
}
