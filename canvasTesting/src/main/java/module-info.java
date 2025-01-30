module org.example.canvastesting {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.canvastesting to javafx.fxml;
    exports org.example.canvastesting;
}