package vinnsla;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * Klasi sem heldur utanum virkni klukkunnar
 */
public class Klukka {
    public SimpleIntegerProperty time;

    /**
     * Smiður fyrir nýja klukku
     * @param i tími klukku
     */
    public Klukka(int i) {
        time = new SimpleIntegerProperty(i);
    }

    /**
     * Minnkar tímann um eina sek
     */
    public void tic() {
        time.set(time.get()-1);
        System.out.println(time.get());
    }

    /**
     * Setur tímann sem time
     * @param time int tími
     */
    public void setTime(int time) {
        this.time.set(time);
    }

    /**
     * Skilar tímanum
     * @return tími eftir
     */
    public int getTime() {
        return time.get();
    }
}
