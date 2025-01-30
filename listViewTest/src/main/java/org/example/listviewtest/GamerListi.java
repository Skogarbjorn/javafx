package org.example.listviewtest;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

public class GamerListi extends ListView<Gamer> {
    public GamerListi() {
        setItems(FXCollections.observableArrayList());
    }

    public void addGamer(Gamer gamer) {
        getItems().add(gamer);
        FXCollections.sort(getItems());
    }
}
