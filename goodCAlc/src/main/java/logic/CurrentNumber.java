package logic;

public abstract class CurrentNumber {
    public static double currentNumber;
    public static String currentString = "";
    public static boolean first = true;

    public static void addToString(String a) {
        currentString = currentString.concat(a);
        updateNumber();
    }

    public static void setString(String a) {
        currentString = a;
    }

    public static void updateNumber() {
        if (!currentString.isEmpty()) {
            currentNumber = Double.parseDouble(currentString);
            send();
        } else {Formatting.removeFromList(); first = true;}
    }

    public static void send() {
        if (first) {
            Formatting.addNumberToList(currentNumber);
            first = false;
        } else Formatting.updateNumberInList(currentNumber);
    }

    public static void removeFromString() throws NullPointerException {
        if (Printing.intChecker(Double.parseDouble(currentString))) {
            currentString = currentString.substring(0, currentString.length()-3);
        } else currentString = currentString.substring(0, currentString.length()-1);
        updateNumber();
    }

    public static boolean isEmpty() {
        return currentString.isEmpty();
    }

    public static void finalizeNumber() throws NullPointerException {
        if (currentString.isEmpty()) throw new NullPointerException();
        currentString = "";
        first = true;
    }

    public static char peek() {
        return currentString.charAt(currentString.length()-1);
    }

    public static void clear() {
        currentString = "";
        first = true;
    }
}
