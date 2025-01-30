package test;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class GamerApplication extends Application {
    private ListView<String> list = new ListView<>();
    private ObservableList<String> items = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws Exception {
        list.setItems(items);
        ProgressBar slider = new ProgressBar(50);
        slider.setPrefWidth(300);
        slider.setPrefHeight(10);
        slider.setProgress(0.0);
        VBox box = new VBox(list, slider);
        Scene s = new Scene(box, 300, 500);
        stage.setScene(s);
        stage.setTitle("gamer");
        stage.show();
        for (int i = 0; i < 100; i++) {
            items.add(Integer.toString(i));
        }

        slider.progressProperty().bind(list.getSelectionModel().selectedIndexProperty().divide(100.0));

        Button b = new Button();
        b.setText("Eyða entry");
        b.setOnAction(e -> deleteEntry());
        Button b1 = new Button();
        b1.setText("Bæta við entry");
        b1.setOnAction(e -> addEntry());

        box.getChildren().add(b);
        box.getChildren().add(b1);
    }

    private void deleteEntry() {
        TextInputDialog t = new TextInputDialog();
        Optional<String> s = t.showAndWait();
        s.ifPresent(string -> items.remove(string));
    }

    private void addEntry() {
        TextInputDialog t = new TextInputDialog();
        Optional<String> s = t.showAndWait();
        s.ifPresent(string -> items.add(string));

        FXCollections.sort(items);
    }
}
