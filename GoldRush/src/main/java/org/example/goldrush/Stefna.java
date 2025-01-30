package org.example.goldrush;

/**
 * Stefna sem leikmaður fer í
 */
public enum Stefna {
    UP(90),
    DOWN(270),
    LEFT(180),
    RIGHT(360);

    private final int degrees;

    /**
     * Smiður sem setur gráður sem s
     * @param s gráður
     */
    Stefna(int s) {
        degrees=s;
    }

    /**
     * Skilar gráðum
     * @return gráður
     */
    public int getDegrees() {
        return degrees;
    }
}
