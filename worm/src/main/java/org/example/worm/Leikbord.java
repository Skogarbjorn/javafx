package org.example.worm;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Random;

public class Leikbord extends Pane {
    @FXML
    private Worm worm;

    public SimpleIntegerProperty points = new SimpleIntegerProperty(0);

    private ObservableList<Gull> gull = FXCollections.observableArrayList();

    public Leikbord() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/worm/leikbord-view.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    /* private void goldCollision() {
        try {
            for (Node i : entityPane.getChildren()) {
                if (i.getClass() == Gull.class && worm.getPlayerBounds().intersects(i.getBoundsInParent())) {
                    entityPane.getChildren().remove(i);
                    gull.remove(i);
                    points.set(points.get() + 100);
                }
            }
        } catch (ConcurrentModificationException ignored) {}
    }
    */



    public void makeMoreGold() {
        Random random = new Random();

        Gull gull1 = new Gull();
        gull1.setLayoutX(random.nextInt(460) - 10.0);
        gull1.setLayoutY(random.nextInt(460) + 20.0);
        gull.add(gull1);
    }

    public void clear() {
        gull.clear();
    }
}
