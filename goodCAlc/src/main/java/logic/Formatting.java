package logic;

import org.example.goodcalc.Controller;

import java.util.ArrayList;

public abstract class Formatting {
    private static ArrayList<Object> operationsList = new ArrayList<>();
    private Controller controller;


    public static void setOperationsList(ArrayList<Object> operationsList) {
        Formatting.operationsList = operationsList;
    }

    public static ArrayList<Object> getOperationsList() {
        return new ArrayList<>(operationsList);
    }

    public static void addNumberToList(double x) {
        operationsList.add(Position.index, x);
        Position.right();
    }

    public static void updateNumberInList(double x) {
        operationsList.set(Position.index-1, x);
    }

    public static void addOperationToList(Object x) {
        operationsList.add(Position.index, x);
        Position.right();
    }

    public static void removeFromList() throws NullPointerException {
        if (operationsList.isEmpty()) {
            throw new NullPointerException();
        }
        Position.left();
        CurrentNumber.clear();
        System.out.println("gamer" + Formatting.operationsList);
        Formatting.operationsList.remove(Position.index);
    }

    public static void clear() {
        operationsList.clear();
    }
}
