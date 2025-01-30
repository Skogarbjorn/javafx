package objects;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import org.example.bombermanmover2d.HelloController;
import player.Player;
import player.Stats;

public class Bomb {
    private HelloController controller;

    private Timeline timer;
    private Player player;
    private int x;
    private int y;

    public Bomb(int x, int y, Player player, HelloController controller) {
        this.controller = controller;

        this.player = player;
        this.x = x;
        this.y = y;

        timer = new Timeline(new KeyFrame(Duration.millis(player.getStats().getBombTime()), e -> explodeBomb()));
        timer.setCycleCount(0);
        timer.play();
    }

    public void explodeBomb() {
        controller.explodeBomb(x,y, this);
        player.removeBomb();
    }

    public Stats getStats() {
        return player.getStats();
    }
}
