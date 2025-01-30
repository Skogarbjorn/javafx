package map;

import objects.Wall;

import java.util.Random;

public abstract class GameMapDefault {
    private static final int SIZE = 12;
    private static final Object[][] map = new Object[SIZE][SIZE];
    private static final Random random = new Random();

    public static void initialize() {
        generateMap();
    }


    private static void generateMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    map[i][j] = new Wall(Wall.STATUS.PERMANENT);
                }
                else if (random.nextInt(100) < 90) {
                    map[i][j] = null;
                }
                else {
                    map[i][j] = new Wall(Wall.STATUS.DESTRUCTIBLE);
                }
            }
        }
        map[0][0] = null;
        map[0][1] = null;
        map[1][0] = null;
        map[11][11] = null;
        map[10][11] = null;
        map[11][10] = null;
    }

    public static Object[][] getMap() {
        return map;
    }
}
