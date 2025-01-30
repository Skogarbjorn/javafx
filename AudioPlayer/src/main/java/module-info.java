module org.example.audioplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens org.example.vidmot to javafx.fxml;
    exports org.example.vidmot;
}
