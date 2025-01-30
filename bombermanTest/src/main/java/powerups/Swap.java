package powerups;

import javafx.scene.paint.Color;
import player.Position;

public class Swap implements Powerups {
    private Position player;

    public void setPlayer(Position player) {
        this.player = player;
    }

    public Color getMainColor() {
        return Color.WHITE;
    }

    public Color getOutlineColor() {
        return Color.BLACK;
    }
}
