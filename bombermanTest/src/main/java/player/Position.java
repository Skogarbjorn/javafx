package player;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import map.Map;
import objects.Bomb;
import org.example.bombermantest.HelloController;
import powerups.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Position {
    @FXML
    private Label player;
    @FXML
    private GridPane grid;
    private HelloController controller;
    private int x;
    private int y;
    private int bombRadius=1;
    private int bombTime=2500;
    private final IntegerProperty life = new SimpleIntegerProperty(3);
    private int maxLife = 3;
    private ArrayList<Bomb> bombs = new ArrayList<Bomb>();
    private int maxBombs = 1;

    public Position(HelloController controller, Label player) {
        this.controller = controller;
        this.player = player;
    }

    public void move(int i, Label player) {
        x = GridPane.getColumnIndex(player);
        y = GridPane.getRowIndex(player);
        switch (i) {
            case 0: if (isLegal(x, y-1)) y--;
            break;
            case 1: if (isLegal(x-1, y)) x--;
            break;
            case 2: if (isLegal(x, y+1)) y++;
            break;
            case 3: if (isLegal(x+1, y)) x++;
            break;
        }
    }

    private boolean isLegal(int x, int y) {
        try {
            Object test = Map.getCollisionMap()[x][y];
            Position[] players = controller.getPlayer();
            Position player = players[0];
            Position player1 = players[1];
            int[] collisionPos = new int[]{x,y};
            if (Arrays.equals(collisionPos, player.getPos()) || Arrays.equals(collisionPos, player1.getPos())) return false;
            if (test.getClass() == Range.class) {
                rangeGet((Range) test, x, y);
                return true;
            }
            if (test.getClass() == Time.class) {
                timeGet((Time) test, x, y);
                return true;
            }
            if (test.getClass() == OneUp.class) {
                oneUpGet((OneUp) test, x, y);
                return true;
            }
            if (test.getClass() == Swap.class) {
                swapGet((Swap) test, x, y);
                return false;
            }
            if (test.getClass() == MoreBomb.class) {
                moreBombGet((MoreBomb) test, x, y);
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException ex) {
            return false;
        } catch (NullPointerException ex) {
            return true;
        }
    }

    public void addBomb() {
        if (maxBombs > bombs.size()) {
            bombs.add(new Bomb(this, controller, drawBomb()));
        }
    }

    private Circle drawBomb() {
        Circle bomb = new Circle();
        bomb.setRadius(30);
        bomb.setFill(Color.DODGERBLUE);
        bomb.setStroke(Color.BLACK);
        bomb.setStrokeType(StrokeType.INSIDE);
        controller.addToGrid(bomb,x,y);
        GridPane.setHalignment(bomb, HPos.CENTER);
        return bomb;
    }

    public void removeBomb() {
        bombs.remove(0);
    }

    private void rangeGet(Range range, int x, int y) {
        range.setPlayer(this);
        controller.removeWall(x,y);
        Map.removeTile(x,y);
        bombRadius++;
    }

    private void timeGet(Time time, int x, int y) {
        time.setPlayer(this);
        controller.removeWall(x,y);
        Map.removeTile(x,y);
        if (bombTime > 500) {
            bombTime-=300;
        }
    }

    private void oneUpGet(OneUp oneUp, int x, int y) {
        oneUp.setPlayer(this);
        controller.removeWall(x,y);
        Map.removeTile(x,y);
        maxLife++;
        life.set(life.get()+1);
    }

    private void swapGet(Swap swap, int x, int y) {
        swap.setPlayer(this);
        controller.removeWall(x,y);
        Map.removeTile(x,y);
        controller.swapPlayers();
    }

    private void moreBombGet(MoreBomb moreBomb, int x, int y) {
        moreBomb.setPlayer(this);
        controller.removeWall(x,y);
        Map.removeTile(x,y);
        maxBombs++;
    }

    public boolean oneLife() {
        return life.get() == 1;
    }

    public void minusLife() {
        life.set(life.get()-1);
    }

    public int getLife() {
        return life.get();
    }

    public int getMaxLife() {
        return maxLife;
    }

    public IntegerProperty lifeProperty() {
        return life;
    }

    public int getBombTime() {
        return bombTime;
    }

    public void setPos(int[] pos) {
        this.x = pos[0];
        this.y = pos[1];
    }

    public int[] getPos() {
        return new int[]{x,y};
    }

    public Bomb getNextBomb() {
        return bombs.get(0);
    }

    public int getRadius() {
        return bombRadius;
    }
}
