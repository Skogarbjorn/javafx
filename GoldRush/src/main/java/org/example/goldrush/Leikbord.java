package org.example.goldrush;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Random;

/**
 * Leikborð object sem inniheldur allt sem fer fram í leiknum
 */
public class Leikbord extends Pane {
    private Stefna stefna;

    public SimpleIntegerProperty points = new SimpleIntegerProperty(0);

    private ObservableList<Gull> golds = FXCollections.observableArrayList();

    @FXML
    private Grafari fxGrafari;

    /**
     * Smiður sem les fxml skrá
     */
    public Leikbord() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/goldrush/leikbord-view.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Færir leikmann í átt sem var valin og athugar hvort hann hafi náð í gull
     */
    public void afram() {
        switch (stefna) {
            case UP: if (isLegal(fxGrafari.getLayoutX(), fxGrafari.getLayoutY()-10)) fxGrafari.setLayoutY(fxGrafari.getLayoutY()-10);
                break;
            case LEFT: if (isLegal(fxGrafari.getLayoutX()-10, fxGrafari.getLayoutY())) fxGrafari.setLayoutX(fxGrafari.getLayoutX()-10);
                break;
            case DOWN: if (isLegal(fxGrafari.getLayoutX(), fxGrafari.getLayoutY()+10)) fxGrafari.setLayoutY(fxGrafari.getLayoutY()+10);
                break;
            case RIGHT: if (isLegal(fxGrafari.getLayoutX()+10, fxGrafari.getLayoutY())) fxGrafari.setLayoutX(fxGrafari.getLayoutX()+10);
                break;
            default: break;
        }
        isGold();
    }

    /**
     * Athugar hvort staðsetning sé innan marka Leikbordsins
     * @param x x hnit
     * @param y y hnit
     * @return löglegt eða ekki
     */
    private boolean isLegal(double x, double y) {
		return x >= 0 && x < 470 && y >=26 && y < 450;
	}

    /**
     * Tékkar hvort leikmaður sé ofaná gulli og grefur ef svo er
     */
    private void isGold() {
        Gull gull=null;
        boolean isGull=false;
        for (Gull x : golds) {
            if (fxGrafari.getBoundsInParent().intersects(x.getBoundsInParent())) {
                gull = x;
                isGull=true;
                points.set(points.get()+100);
                break;
            }
        }
        if (isGull) digGold(gull);
    }

    /**
     * Grefur gull x
     * @param x gull
     */
    private void digGold(Gull x) {
        golds.remove(x);
        this.getChildren().removeIf(x::equals);
    }

    /**
     * Breytir stefnu
     * @param i stefna
     */
    public void setStefna(Stefna i) {
        stefna=i;
    }

    /**
     * Breytir stefnu og færir leikmann áfram
     * @param i
     */
    public void stefna(Stefna i) {
        if (i != null) {
            setStefna(i);
            afram();
        }
    }

    /**
     * Bætir við meira gulli á leikborðið
     */
    public void moreGold() {
        Gull gull = new Gull();
        Random random = new Random();
        gull.setLayoutX(random.nextInt(470));
        gull.setLayoutY(random.nextInt(454)+26);
        this.getChildren().add(gull);
        golds.add(gull);
    }

    /**
     * Hreinsar allt gullið
     */
    public void clean() {
        golds.clear();
        this.getChildren().removeIf(x -> x.getClass() == Gull.class);
    }

    /**
     * Endurræsir stig og hreinsar
     */
    public void reset() {
        points.set(0);
        clean();
    }
}
