package org.example.audioplayerredo;

public enum View {
    MAIN("main-view.fxml"),
    ALBUM("album-view.fxml");

    private String view;

    View(String view) {
        this.view = view;
    }

    String getName() {
        return view;
    }
}
