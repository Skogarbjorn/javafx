package player;

import map.Map;
import objects.Bomb;
import org.example.bombermanmover2d.HelloController;

import java.util.ArrayList;

public class Player {
    private HelloController controller;

    private double x;
    private double y;

    private ArrayList<Bomb> bombs;
    private boolean insideBomb=false;

    private Stats stats;

    public boolean up=false;
    public boolean down=false;
    public boolean right=false;
    public boolean left=false;


    public Player(double x, double y, HelloController controller) {
        this.controller = controller;

        this.x = x;
        this.y = y;
        bombs = new ArrayList<>();
        stats = new Stats();
    }

	public boolean hasMoreBomb() {
			return bombs.size() < stats.getMaxBombs();
	}

    public void addBomb(int[] coords) {
			Bomb bomb = new Bomb(coords[0], coords[1], this, controller);
			insideBomb=true;
			bombs.add(bomb);
			controller.drawBomb(coords[0], coords[1]);
			Map.addToMap(coords, bomb);
    }

    public void removeBomb() {
        bombs.remove(0);
    }

    public boolean isInsideBomb() {
        return insideBomb;
    }

    public void setInsideBomb(boolean insideBomb) {
        this.insideBomb = insideBomb;
    }

    public Stats getStats() {
        return stats;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
