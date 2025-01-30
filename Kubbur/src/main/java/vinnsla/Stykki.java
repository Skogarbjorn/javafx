package vinnsla;

public class Stykki {
    private String nafnAMynd;
    private int tala;
    private static int counter=0;

    /**
     * Smiður sem tekur inn nafn myndarinnar.
     * @param nafnAMynd Nafn
     */
    public Stykki(String nafnAMynd) {
        this.nafnAMynd = nafnAMynd;
        this.tala = ++counter;
    }

    /**
     * Skilar nafni myndarinnar
     * @return Nafn
     */
    public String getNafn() {
        return nafnAMynd;
    }

    /**
     * Skilar tölu stykkisins
     * @return Tala
     */
    public int getTala() {
        return tala;
    }
}
