package objects;

import java.util.Random;

public class Wall {
    private STATUS status;
    private boolean hasRange=false;
    private boolean hasTime=false;
    private boolean hasOneUp=false;
    private boolean hasSwap=false;
    private boolean hasMoreBomb=false;

    public enum STATUS {
        DESTRUCTIBLE, PERMANENT;
    }

    public Wall(STATUS status) {
        this.status = status;
        Random random = new Random();
        if (random.nextInt(100) > 65) {
            hasRange=true;
        }
        else if (random.nextInt(50) > 43) {
            hasTime=true;
        }
        else if (random.nextInt(100) > 85) {
            hasOneUp=true;
        }
        else if (random.nextInt(50) > 45) {
            hasSwap=true;
        }
        else if (random.nextInt(100) > 80) {
            hasMoreBomb=true;
        }
    }

    public STATUS getStatus() {
        return status;
    }

    public boolean hasRange() {
        return hasRange;
    }

    public boolean hasTime() {
        return hasTime;
    }

    public boolean hasOneUp() {
        return hasOneUp;
    }

    public boolean hasSwap() {
        return hasSwap;
    }

    public boolean hasMoreBomb() {
        return hasMoreBomb;
    }
}
