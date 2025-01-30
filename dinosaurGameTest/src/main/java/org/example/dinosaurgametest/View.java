package org.example.dinosaurgametest;

public enum View {
    MAIN("dino-view.fxml"),
    GAME("game-view.fxml");

    String name;

    View(String s) {
        name = s;
    }

    String getName() {
        return name;
    }
}
