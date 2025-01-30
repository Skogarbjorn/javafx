package logic;

import java.util.ArrayList;

public abstract class Printing {
    public static boolean intChecker(double d) {
        return Math.abs((int) d - d) < 1e-14;
    }

    public static String printer(ArrayList<Object>list) {
        String print = "";
        for (int i = 0; i < list.size(); i++) {
            String next;
            if (list.get(i).getClass().equals(Double.class)) {
                double nextDouble = Double.parseDouble(list.get(i).toString());

                if (intChecker(nextDouble)) {
                    next = Integer.toString((int) nextDouble);
                } else {
                    next = Double.toString(nextDouble);
                }
            } else next = list.get(i).toString();
            if (Position.index == i) print = print.concat(" ");
            print = print.concat(next);
        }
        return print;
    }
}
