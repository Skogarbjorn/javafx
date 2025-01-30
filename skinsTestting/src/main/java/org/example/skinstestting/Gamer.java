package org.example.skinstestting;

import javafx.beans.property.ObjectProperty;
import javafx.scene.Node;
import javafx.scene.control.Skin;
import javafx.scene.control.Skinnable;

public class Gamer implements Skinnable, Skin<Gamer> {
    public Gamer getSkinnable() {
        return null;
    }

    public Node getNode() {
        return null;
    }

    public void dispose() {

    }

    public ObjectProperty<Skin<?>> skinProperty() {
        return null;
    }

    public void setSkin(Skin<?> skin) {

    }

    public Skin<?> getSkin() {
        return null;
    }
}
