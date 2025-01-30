package org.example.bombermantest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import map.GameMapDefault;
import map.Map;
import objects.Wall;
import player.Position;
import powerups.*;

import java.util.Arrays;

public class HelloController {
    @FXML
    private Label player;
    @FXML
    private Label player1;
    private Position playerMovement = new Position(this, player);
    private Position playerMovement1 = new Position(this, player1);
    @FXML
    private GridPane grid;

    @FXML
    private void playerHandler(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        if (code.equals(KeyCode.UP)) playerMovement.move(0, player);
        if (code.equals(KeyCode.W)) playerMovement1.move(0, player1);
        if (code.equals(KeyCode.DOWN)) playerMovement.move(2, player);
        if (code.equals(KeyCode.S)) playerMovement1.move(2, player1);
        if (code.equals(KeyCode.LEFT)) playerMovement.move(1, player);
        if (code.equals(KeyCode.A)) playerMovement1.move(1, player1);
        if (code.equals(KeyCode.RIGHT)) playerMovement.move(3, player);
        if (code.equals(KeyCode.D)) playerMovement1.move(3, player1);

        if (code.equals(KeyCode.M)) bomb(playerMovement);
        if (code.equals(KeyCode.SPACE)) bomb(playerMovement1);

        System.out.println(player1.getBoundsInParent());
    }

    private void bomb(Position playerPos) {
        playerPos.addBomb();
    }

    public void updatePos() {
        int[] pos = playerMovement.getPos();
        GridPane.setColumnIndex(player, pos[0]);
        GridPane.setRowIndex(player, pos[1]);
        int[] pos1 = playerMovement1.getPos();
        GridPane.setColumnIndex(player1, pos1[0]);
        GridPane.setRowIndex(player1, pos1[1]);
    }

    private void tick() {
        grid.requestFocus();
        updatePos();
    }

    public void removeBomb(Position playerPos) {
        grid.getChildren().remove(playerPos.getNextBomb().getCircle());
    }

    public void explodeBomb(Position playerPos) {
        int[] pos = playerPos.getNextBomb().getPos();
        int blastRadius = playerPos.getRadius();
        explodeTilePlayer(pos);
        for (int i=1;i<blastRadius+1;i++){
            if (!explodeTile(pos[0],pos[1]+i)) break;
        }
        for (int i=1;i<blastRadius+1;i++){
            if (!explodeTile(pos[0],pos[1]-i)) break;
        }
        for (int i=1;i<blastRadius+1;i++){
            if (!explodeTile(pos[0]+i,pos[1])) break;
        }
        for (int i=1;i<blastRadius+1;i++){
            if (!explodeTile(pos[0]-i,pos[1])) break;
        }
    }

    private void explodeTilePlayer(int[] pos) {
        if (Arrays.equals(pos, playerMovement.getPos())) removePlayer(player, playerMovement);
        if (Arrays.equals(pos, playerMovement1.getPos())) removePlayer(player1, playerMovement1);
    }

    private void dropFromWall(Wall wall, int x, int y) {
        if (wall.hasRange()) {
            Range range = new Range();
            Map.addToMap(new int[]{x,y},range);
            addPower(x,y,range);
        }
        else if (wall.hasTime()) {
            Time time = new Time();
            Map.addToMap(new int[]{x,y},time);
            addPower(x,y,time);
        }
        else if (wall.hasOneUp()) {
            OneUp oneUp = new OneUp();
            Map.addToMap(new int[]{x,y},oneUp);
            addPower(x,y,oneUp);
        }
        else if (wall.hasSwap()) {
            Swap swap = new Swap();
            Map.addToMap(new int[]{x,y},swap);
            addPower(x,y,swap);
        }
        else if (wall.hasMoreBomb()) {
            MoreBomb moreBomb = new MoreBomb();
            Map.addToMap(new int[]{x,y},moreBomb);
            addPower(x,y,moreBomb);
        }
    }

    private void addPower(int x, int y, Powerups powerup) {
        Circle power = new Circle();
        power.setRadius(15);
        power.setFill(powerup.getMainColor());
        power.setStroke(powerup.getOutlineColor());
        power.setStrokeType(StrokeType.INSIDE);
        grid.add(power, x, y);
        GridPane.setHalignment(power, HPos.CENTER);
    }

    private boolean explodeTile(int x, int y) {
        try {
            Wall wall;
            int[] pos = new int[]{x,y};
            if (Arrays.equals(playerMovement.getPos(), pos)) {
                removePlayer(player, playerMovement);
            }
            if (Arrays.equals(playerMovement1.getPos(), pos)) {
                removePlayer(player1, playerMovement1);
            }
            if (Map.getCollisionMap()[x][y].getClass() == Wall.class) {
                wall = (Wall) Map.getCollisionMap()[x][y];
                if (wall.getStatus() == Wall.STATUS.DESTRUCTIBLE) {
                    Map.removeTile(x, y);
                    dropFromWall(wall,x,y);
                    removeWall(x,y);
                }
                else return false;
            }
            else {
                Map.removeTile(x, y);
                removeWall(x, y);
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {return true;}
    }

    public void removeWall(int x, int y) {
        ObservableList<Node> children = grid.getChildren();
        for (int i = 0; i < children.size(); i++) {
            Node child = children.get(i);
            if (GridPane.getColumnIndex(child) == x && GridPane.getRowIndex(child) == y) {
                children.remove(i);
                break;
            }
        }
    }

    private void removePlayer(Label player, Position playerMovement) {
        if (playerMovement.oneLife()) {
            grid.getChildren().remove(player);
            playerMovement.setPos(new int[]{100,100});
        } else playerMovement.minusLife();
    }

    private void drawMap() {
        Object[][] gamer = GameMapDefault.getMap();
        for (int i=0;i<gamer.length;i++) {
            for (int j=0;j<gamer[i].length;j++) {
                if (gamer[i][j] != null) typeDraw((Wall) gamer[i][j], i, j);
            }
        }
    }

    private void typeDraw(Wall wall, int i, int j) {
        if (wall.getStatus() == Wall.STATUS.DESTRUCTIBLE) drawWall("gray", i, j);
        else drawWall("black", i, j);
    }

    private void drawWall(String color, int i, int j) {
        Label wall = new Label();
        wall.setMaxWidth(Double.MAX_VALUE);
        wall.setMaxHeight(Double.MAX_VALUE);
        wall.setStyle("-fx-background-color: " + color + ";");
        grid.add(wall, i, j);
    }

    public void addToGrid(Circle bomb, int x, int y) {
        grid.add(bomb, x, y);
    }

    public void swapPlayers() {
        int[] p1Pos = playerMovement.getPos();
        playerMovement.setPos(playerMovement1.getPos());
        playerMovement1.setPos(p1Pos);
        System.out.println(Arrays.toString(playerMovement.getPos()));
        System.out.println(Arrays.toString(playerMovement1.getPos()));
    }

    public Position[] getPlayer() {
        return new Position[]{playerMovement, playerMovement1};
    }

    public void initialize() {
        GameMapDefault.initialize();
        drawMap();

        playerMovement.setPos(new int[]{0,0});
        playerMovement1.setPos(new int[]{grid.getColumnCount()-1,grid.getRowCount()-1});

        grid.setOnKeyPressed(this::playerHandler);

        player.opacityProperty().bind(Bindings.createDoubleBinding(() -> (double) playerMovement.getLife()/playerMovement.getMaxLife(), playerMovement.lifeProperty()));
        player1.opacityProperty().bind(Bindings.createDoubleBinding(() -> (double) playerMovement1.getLife()/playerMovement1.getMaxLife(), playerMovement1.lifeProperty()));

        Timeline tickTime = new Timeline(new KeyFrame(Duration.millis(10), e -> tick()));
        tickTime.setCycleCount(Timeline.INDEFINITE);
        tickTime.play();


    }
}
