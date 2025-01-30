package vinnsla;

import java.util.Random;

public class Stykki {
    private Random random;
    private int currentRandom;

    public Stykki() {
        random = new Random();
    }

    public void makeRandom() {
        currentRandom = random.nextInt(9)+1;
    }

    public int getCurrentRandom() {
        return currentRandom;
    }
}
