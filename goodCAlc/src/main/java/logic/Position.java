package logic;

public abstract class Position {
    public static int index = 0;

    public static void left() {
        if (index > 0) {
            index--;
        }
    }

    public static void right() {
        if (index < Formatting.getOperationsList().size()) {
            index++;
        }
    }

    public static void last() {
        index = Formatting.getOperationsList().size();
    }

    public static void clear() {
        index = 0;
    }
}
