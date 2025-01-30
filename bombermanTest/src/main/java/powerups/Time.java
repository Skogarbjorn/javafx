package powerups;

import javafx.scene.paint.Color;
import player.Position;

public class Time implements Powerups {
    private Position player;

    public void setPlayer(Position player) {
        this.player = player;
    }

    public Color getMainColor() {
        return Color.MEDIUMPURPLE;
    }

    public Color getOutlineColor() {
        return Color.PURPLE;
    }
}
