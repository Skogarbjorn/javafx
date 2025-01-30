package computing;

public class Numbers {
    private Calculations num1 = new Calculations();
    private String storedNumber = "";
    private Operation operation;

    public enum Operation {
        PLUS, MINUS, MULTIPLY, DIVIDE, POWER
    }

    public void setStoredNumber(String i) {
        storedNumber = storedNumber.concat(i);
    }

    public void removeNumber() throws NullPointerException {
        if (storedNumber.isEmpty()) {
            throw new NullPointerException();
        }
        storedNumber = storedNumber.substring(0, storedNumber.length()-1);
    }

    public String getStoredNumber() {
        return storedNumber;
    }

    public void plus() {
            num1.setCalculationNumber(Double.parseDouble(storedNumber));
            operation = Operation.PLUS;
            storedNumber = "";
    }

    public void minus() {
            num1.setCalculationNumber(Double.parseDouble(storedNumber));
            operation = Operation.MINUS;
            storedNumber = "";
    }

    public void multiply() {
            num1.setCalculationNumber(Double.parseDouble(storedNumber));
            operation = Operation.MULTIPLY;
            storedNumber = "";
    }

    public void divide() {
            num1.setCalculationNumber(Double.parseDouble(storedNumber));
            operation = Operation.DIVIDE;
            storedNumber = "";
    }

    public void power() {
            num1.setCalculationNumber(Double.parseDouble(storedNumber));
            operation = Operation.POWER;
            storedNumber = "";
    }

    public String enter() throws ArithmeticException {
        try {
            if (operation == Operation.PLUS) {
                num1.plus(Double.parseDouble(storedNumber));
            } else if (operation == Operation.MINUS) {
                num1.minus(Double.parseDouble(storedNumber));
            } else if (operation == Operation.MULTIPLY) {
                num1.multiply(Double.parseDouble(storedNumber));
            } else if (operation == Operation.DIVIDE) {
                num1.divide(Double.parseDouble(storedNumber));
            } else if (operation == Operation.POWER) {
                num1.power(Double.parseDouble(storedNumber));
            }
            double calculationNumber = num1.getCalculationNumber();
            if (Math.abs((int)calculationNumber - calculationNumber) < 1e-15) {
                storedNumber = Integer.toString((int) calculationNumber);
            } else {
                storedNumber = Double.toString(calculationNumber);
            }
            return storedNumber;
        } catch (ArithmeticException ex) {
            throw new ArithmeticException();
        }
    }

    public void clear() {
        storedNumber = "";
        num1 = new Calculations();
    }
}
