package vinnsla;

import javafx.beans.property.SimpleIntegerProperty;

public class Points {
    public static SimpleIntegerProperty points = new SimpleIntegerProperty(0);

    public static void add() {
        points.set(points.get() + 10);
    }

    public static void reset() {
        points.set(0);
    }
}
