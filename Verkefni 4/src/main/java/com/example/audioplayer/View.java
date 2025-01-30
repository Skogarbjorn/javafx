package com.example.audioplayer;

public enum View {
    MAIN("Forsida.fxml"),
    LISTI("Listar.fxml");

    private String fxmlName;

    View(String fxmlName) {
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}