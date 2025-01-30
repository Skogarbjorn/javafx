package logic.operations;

public class Subtract {
    private double num1;

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double subtract(double num2) {
        return num1 - num2;
    }

    public String toString() {
        return "-";
    }
}
