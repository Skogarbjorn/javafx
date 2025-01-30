package vinnsla;

/**
 * Hlutur sem geymir nafn askrifanda
 */
public class Askrifandi {
    private String nafn;

    /**
     * Smiður sem setur nafn sem nafn
     * @param nafn nafn askrifanda
     */
    public Askrifandi(String nafn) {
        this.nafn = nafn;
    }

    /**
     * Breytir nafninu í nafn
     * @param nafn nafn sem við viljum setja
     */
    public void setNafn(String nafn) {
        this.nafn = nafn;
    }

    /**
     * Skilar nafni askrifanda
     * @return nafn
     */
    public String getNafn() {
        return nafn;
    }
}
