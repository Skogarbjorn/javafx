package org.example.vidmot;

/**
 * Velur hvora fxml skrá á að nota
 */
public enum View {
    MAIN("heima-view.fxml"),
    LISTAR("listi-view.fxml");

    private String fileName;

    /**
     * Smiður
     * @param fileName
     */
    View(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Skilar nafni á fxml skrá
     * @return
     */
    public String getFileName() {
        return fileName;
    }
}
