module org.example.vector2dtest {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.vector2dtest to javafx.fxml;
    exports org.example.vector2dtest;
}