package vinnsla;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.Arrays;
import java.util.Random;

public class Kubbur {
    private int[][] numberGrid;
    private int currentGuess;

    public Kubbur() {
        numberGrid = new int[3][3];
        Random random = new Random();
        int x,y;
        for (int i = 1; i < 10; i++) {
            do {
                x = random.nextInt(3);
                y = random.nextInt(3);
            } while (numberGrid[x][y] != 0);
            numberGrid[x][y] = i;
        }
        System.out.println(Arrays.deepToString(numberGrid));
    }

    public void setCurrentGuess(int currentGuess) {
        this.currentGuess = currentGuess;
    }

    public int getCurrentGuess() {
        return currentGuess;
    }

    public int get(Button button) {
        int x = GridPane.getColumnIndex(button);
        int y = GridPane.getRowIndex(button);
        return numberGrid[x][y];
    }

    public boolean correct(int buttonNumber) {
        return buttonNumber == currentGuess;
    }
}
