package org.example.bombermanmover2d;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import map.GameMapDefault;
import map.Map;
import objects.Bomb;
import objects.Wall;
import player.Player;

public class HelloController {
    @FXML
    private Label player;
    private Player player1;
    @FXML
    private Label secondPlayer;
    private Player secondPlayer1;
    @FXML
    private GridPane grid;
    @FXML
    private StackPane root;

    private double xLim;
    private double yLim;

    private void movementHandler(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.W) player1.up=true;
        if (keyEvent.getCode() == KeyCode.S) player1.down=true;
        if (keyEvent.getCode() == KeyCode.D) player1.right=true;
        if (keyEvent.getCode() == KeyCode.A) player1.left=true;

        if (keyEvent.getCode() == KeyCode.NUMPAD8) secondPlayer1.up=true;
        if (keyEvent.getCode() == KeyCode.NUMPAD5) secondPlayer1.down=true;
        if (keyEvent.getCode() == KeyCode.NUMPAD6) secondPlayer1.right=true;
        if (keyEvent.getCode() == KeyCode.NUMPAD4) secondPlayer1.left=true;
    }

    private void stopHandler(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.W) player1.up=false;
        if (keyEvent.getCode() == KeyCode.S) player1.down=false;
        if (keyEvent.getCode() == KeyCode.D) player1.right=false;
        if (keyEvent.getCode() == KeyCode.A) player1.left=false;

        if (keyEvent.getCode() == KeyCode.NUMPAD8) secondPlayer1.up=false;
        if (keyEvent.getCode() == KeyCode.NUMPAD5) secondPlayer1.down=false;
        if (keyEvent.getCode() == KeyCode.NUMPAD6) secondPlayer1.right=false;
        if (keyEvent.getCode() == KeyCode.NUMPAD4) secondPlayer1.left=false;

        if (keyEvent.getCode() == KeyCode.E) placeBomb(player, player1);
        if (keyEvent.getCode() == KeyCode.NUMPAD7 || keyEvent.getCode() == KeyCode.NUMPAD9) placeBomb(secondPlayer, secondPlayer1);
    }

    private void moveUp(Label player, Player player1) {
        if (player1.up && isLegal(player1.getX(), player1.getY() - 1, player, player1)) {
            player1.setY(player1.getY()-1);
        }
    }

    private void moveDown(Label player, Player player1) {
        if (player1.down && isLegal(player1.getX(), player1.getY() + 1, player, player1)) {
            player1.setY(player1.getY()+1);
        }
    }

    private void moveRight(Label player, Player player1) {
        if (player1.right && isLegal(player1.getX() + 1, player1.getY(), player, player1)) {
            player1.setX(player1.getX()+1);
        }
    }

    private void moveLeft(Label player, Player player1) {
        if (player1.left && isLegal(player1.getX() - 1, player1.getY(), player, player1)) {
            player1.setX(player1.getX()-1);
        }
    }

    private boolean isLegal(double x, double y, Label player, Player player1) {
        if (x <= xLim-player.getWidth() && y <= yLim-player.getHeight() && x >= 0 && y >= 0) {
            if (!insideBomb(x, y) && !insideBomb(x + player.getWidth()-1, y) && !insideBomb(x, y + player.getHeight()-1) && !insideBomb(x + player.getWidth()-1, y + player.getHeight()-1)) {
                player1.setInsideBomb(false);
            }

            if (isFree(x, y, player1) && isFree(x + player.getWidth()-1, y, player1) && isFree(x, y + player.getHeight()-1, player1) && isFree(x + player.getWidth()-1, y + player.getHeight()-1, player1)) {
                return isPlayerCollision(x, y, player);
            }
            return false;
        }
        return false;
    }

    private boolean isPlayerCollision(double x, double y, Label player) {
        double playerSize = player.getWidth();
        if (player.equals(this.player)) {
            return !secondPlayer.getBoundsInParent().intersects(x, y, playerSize, playerSize);
        } else {
            return !this.player.getBoundsInParent().intersects(x, y, playerSize, playerSize);
        }




    }

    private boolean isFree(double x, double y, Player player1) {
        int[] coords = getTile(x,y);
        if (Map.getCollisionMap()[coords[0]][coords[1]] != null) {
            if (player1.isInsideBomb() && Map.getCollisionMap()[coords[0]][coords[1]].getClass() == Bomb.class) {
                return true;
            }
        }

        return Map.getCollisionMap()[coords[0]][coords[1]] == null;
    }

    private boolean insideBomb(double x, double y) {
        int[] coords = getTile(x,y);
        if (Map.getCollisionMap()[coords[0]][coords[1]] == null) return false;
        return Map.getCollisionMap()[coords[0]][coords[1]].getClass() == Bomb.class;
    }

    private void tick() {
        moveUp(player, player1);
        moveDown(player, player1);
        moveRight(player, player1);
        moveLeft(player, player1);

        moveUp(secondPlayer, secondPlayer1);
        moveDown(secondPlayer, secondPlayer1);
        moveRight(secondPlayer, secondPlayer1);
        moveLeft(secondPlayer, secondPlayer1);

        player.setLayoutX(player1.getX());
        player.setLayoutY(player1.getY());

        secondPlayer.setLayoutX(secondPlayer1.getX());
        secondPlayer.setLayoutY(secondPlayer1.getY());
    }

    private void drawMap() {
        Object map[][] = GameMapDefault.getMap();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] != null) {
                    if (((Wall) map[i][j]).getStatus() == Wall.STATUS.DESTRUCTIBLE) drawWall("gray", i, j);
                    else drawWall("black", i, j);
                }
            }
        }
    }

    private void drawWall(String color, int x, int y) {
        Label wall = new Label();
        wall.setMaxHeight(Double.MAX_VALUE);
        wall.setMaxWidth(Double.MAX_VALUE);
        wall.setStyle("-fx-background-color: " + color + ";");
        grid.add(wall, x, y);
    }

    private int[] getTile(double x, double y) {
        int tileX = (int) (x/xLim * grid.getColumnCount());
        int tileY = (int) (y/yLim * grid.getRowCount());
        return new int[]{tileX,tileY};
    }

    private void placeBomb(Label player, Player player1) {
        System.out.println("drawmobomb");
        int[] coords = getTile(player1.getX() + player.getWidth()/2, player1.getY() + player.getHeight()/2);
		if (player1.hasMoreBomb()) {
				if (isFree(coords[0],coords[1], player1)) player1.addBomb(coords);
		}
    }

    public void drawBomb(int x, int y) {
        System.out.println("yoo bomb");
        Circle bomb = new Circle();
        bomb.setRadius(player.getWidth()/2);
        bomb.setFill(Color.DODGERBLUE);
        grid.add(bomb, x, y);
        GridPane.setHalignment(bomb, HPos.CENTER);
        GridPane.setValignment(bomb, VPos.CENTER);
    }

    public void explodeBomb(int x, int y, Bomb bomb) {
        explodeTile(x, y);
        for (int i = 1; i <= bomb.getStats().getBombRange(); i++) {
            if (explodeTile(x, y + i)) break;
        }for (int i = 1; i <= bomb.getStats().getBombRange(); i++) {
            if (explodeTile(x, y - i)) break;
        }for (int i = 1; i <= bomb.getStats().getBombRange(); i++) {
            if (explodeTile(x + i, y)) break;
        }for (int i = 1; i <= bomb.getStats().getBombRange(); i++) {
            if (explodeTile(x - i, y)) break;
        }
    }

    private boolean explodeTile(int x, int y) {
        try {
            Object map[][] = Map.getCollisionMap();
            if (map[x][y] != null && map[x][y].getClass() == Wall.class && ((Wall) map[x][y]).getStatus() == Wall.STATUS.PERMANENT) return false;
			if (map[x][y].getClass() == Bomb.class) {
					Bomb bomb = (Bomb) map[x][y];
					map[x][y] = null;
					explodeBomb(x,y, bomb);
					System.out.println("bomb exploded");
			}
            removeTile(x, y);
            return true;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    private void removeTile(int x, int y) {
        grid.getChildren().removeIf(i -> GridPane.getColumnIndex(i) == x && GridPane.getRowIndex(i) == y);
    }


    public void initialize() {
        root.setOnKeyPressed(this::movementHandler);
        root.setOnKeyReleased(this::stopHandler);

        Timeline tick = new Timeline(new KeyFrame(Duration.millis(5), e -> tick()));
        tick.setCycleCount(Animation.INDEFINITE);
        tick.play();

        player1 = new Player(1, 1, this);
        secondPlayer1 = new Player(569, 569, this);

        xLim = root.getPrefWidth();
        yLim = root.getPrefHeight();

        GameMapDefault.initialize();
        drawMap();
    }

}
