package vinnsla;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Jump {
    private Timeline jumpTimeline;
    private float velocity;
    private int tick;
    private boolean up;

    public Jump() {
        tick = 0;
        up = true;
        jumpTimeline = new Timeline(new KeyFrame(Duration.millis(5), e -> {
            velocity = velCalc(tick, up);
            tick += 0.01;
            if (velocity < 0.01) up = false;
        }));
        jumpTimeline.setCycleCount(Animation.INDEFINITE);
        jumpTimeline.play();
    }

    private float velCalc(float x, boolean up) {
        if (up) return (float) -Math.pow(x,2) + 5;
        else return (float) -Math.pow(x,2);
    }

    public void stop() {
        jumpTimeline.stop();
    }
}
