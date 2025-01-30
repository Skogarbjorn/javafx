package computing;

public class Calculations {
    public double calculationNumber;

    public void setCalculationNumber(double i) {
        calculationNumber = i;
    }

    public double getCalculationNumber() {
        return calculationNumber;
    }

    public void plus(double i) {
        calculationNumber = calculationNumber + i;
    }

    public void minus(double i) {
        calculationNumber = calculationNumber - i;
    }

    public void multiply(double i) {
        calculationNumber = calculationNumber * i;
    }

    public void divide(double i) throws ArithmeticException {
        if (i == 0) {
            throw new ArithmeticException();
        }
        calculationNumber = calculationNumber / i;
    }

    public void power(double i) {
        calculationNumber = Math.pow(calculationNumber, i);
    }
}
