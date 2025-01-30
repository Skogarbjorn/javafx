module org.example.mover2d {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.mover2d to javafx.fxml;
    exports org.example.mover2d;
}