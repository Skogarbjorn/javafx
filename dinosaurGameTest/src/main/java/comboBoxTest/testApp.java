package comboBoxTest;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class testApp extends Application {
    private ObservableList<Gamer> items = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws Exception {
        ComboBox<Gamer> comboBox = new ComboBox<Gamer>();
        items.add(new Gamer(Color.RED, "I am red"));
        items.add(new Gamer(Color.CHARTREUSE, "......"));
        items.add(new Gamer(Color.PERU, "country?"));
        comboBox.setItems(items);
        comboBox.setPrefWidth(250);
        comboBox.setPrefHeight(30);
        comboBox.setPromptText("Select your gamer");
        VBox box = new VBox(comboBox);
        box.setPrefWidth(300);
        box.setPrefHeight(300);
        box.setAlignment(Pos.CENTER);

        Rectangle rect = new Rectangle();
        rect.setWidth(150);
        rect.setHeight(150);
        box.getChildren().add(rect);

        Scene s = new Scene(box, 300, 500);
        stage.setScene(s);
        stage.setTitle("gamering");
        stage.show();

        comboBox.getSelectionModel().selectedItemProperty().addListener((obs, o, n) -> {
            rect.setFill(n.getColor());
        });
    }
}
