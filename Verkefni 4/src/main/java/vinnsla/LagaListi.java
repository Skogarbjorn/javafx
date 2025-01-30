package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LagaListi {
    private ObservableList<Lag> listi = FXCollections.observableArrayList();

    private int index;

    public LagaListi(int i) {
        if (i == 0) {
            Lag lag1 = new Lag(getClass().getResource("/vidmot/album2/Band.mp3").toString(), "Band", getClass().getResource("/vidmot/album2/Band.jpg").toString());
            Lag lag2 = new Lag(getClass().getResource("/vidmot/album2/Planet.mp3").toString(), "Planet", getClass().getResource("/vidmot/album2/Planet.jpg").toString());
            listi.add(lag1);
            listi.add(lag2);
        } else if (i == 1) {
            Lag lag1 = new Lag(getClass().getResource("/vidmot/album1/syarin.mp3").toString(), "Syarin", getClass().getResource("/vidmot/album1/syarin.jpg").toString());
            Lag lag2 = new Lag(getClass().getResource("/vidmot/album1/tentai.mp3").toString(), "Tentai", getClass().getResource("/vidmot/album1/tentai.png").toString());
            listi.add(lag1);
            listi.add(lag2);
        }
    }

    public ObservableList<Lag> getListi() {
        return listi;
    }

    public void setIndex(int i) {
        index = i;
    }
}