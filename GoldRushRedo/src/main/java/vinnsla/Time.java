package vinnsla;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;
import org.example.goldrushredo.MainController;
import org.example.goldrushredo.MenuController;

public class Time {
    private SimpleIntegerProperty time;
    private Timeline timeTimeline;
    private MainController mainController;

    public Time(MainController mainController) {
        this.mainController = mainController;
        timeTimeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> time.subtract(1)));
        timeTimeline.setOnFinished(e -> mainController.stop());
    }

    public void stop() {
        timeTimeline.stop();
    }

    public void start() {
        time = new SimpleIntegerProperty(MenuController.diff);
        timeTimeline.setCycleCount(MenuController.diff);
        timeTimeline.playFromStart();
    }
}
