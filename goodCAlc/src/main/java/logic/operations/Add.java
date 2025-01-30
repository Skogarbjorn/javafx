package logic.operations;

public class Add {
    private double num1;

    public Add() {}

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double add(double num2) {
        return num1 + num2;
    }

    public String toString() {
        return "+";
    }
}
