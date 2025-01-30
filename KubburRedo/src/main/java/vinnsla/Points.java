package vinnsla;

import javafx.beans.property.SimpleIntegerProperty;

public class Points {
    private SimpleIntegerProperty currentPoints;
    private int numberGuesses;

    public Points() {
        currentPoints = new SimpleIntegerProperty(0);
        numberGuesses=0;
    }

    private void increment() {
        currentPoints.set(currentPoints.get() + 10 - numberGuesses);
    }

    public void incorrectGuess() {
        numberGuesses += 1;
        System.out.println(numberGuesses);
    }

    public void correctGuess() {
        increment();
        numberGuesses = 0;
    }

    public SimpleIntegerProperty getCurrentPoints() {
        return currentPoints;
    }
}
