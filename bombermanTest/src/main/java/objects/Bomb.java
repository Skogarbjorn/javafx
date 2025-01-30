package objects;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import map.Map;
import org.example.bombermantest.HelloController;
import player.Position;

public class Bomb {
    private Position playerPos;
    private int x;
    private int y;
    private HelloController controller;
    private Circle circle;
    private Timeline bombTicker;

    public Bomb(Position pos, HelloController controller, Circle circle) {
        this.circle = circle;
        this.controller = controller;
        this.playerPos = pos;
        x=pos.getPos()[0];
        y=pos.getPos()[1];
        Map.addToMap(pos.getPos(), this);
        bombTicker = new Timeline(new KeyFrame(Duration.millis(pos.getBombTime()), e -> explodeBomb()));
        bombTicker.setCycleCount(0);
        bombTicker.play();
    }

    public void explodeBomb() {
        bombTicker.stop();
        controller.explodeBomb(playerPos);
        Map.removeTile(x, y);
        controller.removeBomb(playerPos);
        playerPos.removeBomb();
    }

    public Circle getCircle() {
        return circle;
    }

    public int[] getPos() {
        return new int[]{x,y};
    }
}
