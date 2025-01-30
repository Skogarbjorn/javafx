package logic.operations;

public class Multiply {
    private double num1;

    public Multiply() {}

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double multiply(double num2) {
        return num1 * num2;
    }

    public String toString() {
        return "*";
    }
}
