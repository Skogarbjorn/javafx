module org.example.goldrush {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.goldrush to javafx.fxml;
    exports org.example.goldrush;
}