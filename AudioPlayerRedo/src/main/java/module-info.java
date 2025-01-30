module org.example.audioplayerredo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens org.example.audioplayerredo to javafx.fxml, javafx.media;
    opens misc to javafx.fxml;
    exports org.example.audioplayerredo;
    exports vinnsla;
    exports misc;
}
