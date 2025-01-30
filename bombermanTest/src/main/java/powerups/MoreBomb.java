package powerups;

import javafx.scene.paint.Color;
import player.Position;

public class MoreBomb implements Powerups {
    private Position player;

    public void setPlayer(Position player) {
        this.player = player;
    }

    public Color getMainColor() {
        return Color.LIGHTGREEN;
    }

    public Color getOutlineColor() {
        return Color.GREEN;
    }
}
