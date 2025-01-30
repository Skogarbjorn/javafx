package snua;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SnuaController {
    // tilviksbreytur
    @FXML
    private Rectangle fxRectangle;
    @FXML
    private Polygon fxPolygon;

    private Timeline[] timelines;


    // aðferðir
    @FXML
    private void onStart() {
        for (Timeline t : timelines) {
            if (t.getStatus() == Animation.Status.STOPPED) {
                t.playFromStart();
            }
        }
    }

    @FXML
    private void onStop() {
        for (Timeline t : timelines) {
            if (t.getStatus() == Animation.Status.RUNNING) {
                t.stop();
            }
        }
    }

    public void initialize() {
        timelines = new Timeline[2];

        timelines[0] = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            fxRectangle.setRotate(fxRectangle.getRotate() + 45);
        }));

        timelines[1] = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            fxPolygon.setRotate(fxPolygon.getRotate() + 45);
        }));

        for (Timeline t : timelines) {
            t.setCycleCount(Animation.INDEFINITE);
        }
    }
}
