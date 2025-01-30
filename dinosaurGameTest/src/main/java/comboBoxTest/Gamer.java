package comboBoxTest;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Gamer extends HBox implements Comparable<Gamer> {
    private String name;
    private Rectangle rect;

    public Gamer(Color c, String name) {
        this.name = name;
        rect = new Rectangle();
        rect.setFill(c);
        rect.setWidth(10);
        rect.setHeight(10);
        setWidth(300);
        setHeight(20);
        getChildren().add(rect);
        getChildren().add(new Label(name));
        setAlignment(Pos.CENTER);
        setSpacing(30);
    }

    @Override
    public int compareTo(Gamer that) {
        return name.compareTo(that.getName());
    }

    public String getName() {
        return name;
    }

    public void setColor(Color c) {
        rect.setFill(c);
    }

    public Color getColor() {
        return (Color) rect.getFill();
    }
}
