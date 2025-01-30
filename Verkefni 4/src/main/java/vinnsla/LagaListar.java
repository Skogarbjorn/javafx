package vinnsla;

public class LagaListar {
    private static int index;

    private static LagaListi[] listi = new LagaListi[2];

    public static void setListi(int i) {
        index = i;
    }

    public static void createLists() {
        listi[0] = new LagaListi(0);
        listi[1] = new LagaListi(1);
    }

    public static LagaListi getListi() {
        return listi[index];
    }
}