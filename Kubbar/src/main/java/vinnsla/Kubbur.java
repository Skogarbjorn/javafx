package vinnsla;

import javafx.scene.input.KeyEvent;

public class Kubbur {
    private static int input;
    private static int points;
    private static int totalPoints;


    public static void setInput(KeyEvent e) throws NumberFormatException {
        input = Integer.parseInt(e.getText());
    }

    public static void reset() {
        totalPoints=0;
    }

    public static boolean isEqual(int a) {
        return a==input;
    }

    public static String getPoints() {
        totalPoints+=points;
        return Integer.toString(totalPoints);
    }

    public static void minus() {
        if (points > 1) points--;
    }

    public static void resetPoints() {
        points = 5;
    }
}
