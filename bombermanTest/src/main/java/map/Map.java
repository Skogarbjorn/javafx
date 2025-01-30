package map;

public class Map {
    private static Object[][] collisionMap = GameMapDefault.getMap();

    public static Object[][] getCollisionMap() {
        return collisionMap;
    }

    public static void removeTile(int x, int y) {
        collisionMap[x][y] = null;
    }

    public static void addToMap(int[] pos, Object type) {
        collisionMap[pos[0]][pos[1]] = type;
    }
}
