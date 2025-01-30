package datePickerTest;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DatePickerApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws Exception {
        VBox ap = new VBox();
        Label l = new Label();

        Slider s = new Slider(0,100,1);
        s.setPrefWidth(100);
        s.setPrefHeight(30);
        s.setShowTickLabels(true);
        s.setShowTickMarks(true);

        l.textProperty().equals("eqiup");

        ap.getChildren().add(l);
        ap.getChildren().add(s);
        Scene scene = new Scene(ap, 300, 300);
        stage.setTitle("gamer");
        stage.setScene(scene);
        stage.show();

        l.textProperty().bind(Bindings.createStringBinding(() -> String.valueOf((int) s.getValue()), s.valueProperty()));
    }
}
