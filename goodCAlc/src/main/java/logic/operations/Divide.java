package logic.operations;

public class Divide {
    private double num1;

    public Divide() {}

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double divide(double num2) {
        return num1/num2;
    }

    public String toString() {
        return "/";
    }
}
