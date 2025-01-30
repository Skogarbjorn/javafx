package powerups;

import javafx.scene.paint.Color;
import player.Position;

public class OneUp implements Powerups {
    private Position player;

    public void setPlayer(Position player) {
        this.player = player;
    }

    public Color getMainColor() {
        return Color.RED;
    }

    public Color getOutlineColor() {
        return Color.DARKRED;
    }
}
