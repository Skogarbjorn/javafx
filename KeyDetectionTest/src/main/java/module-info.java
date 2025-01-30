module org.example.keydetectiontest {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.keydetectiontest to javafx.fxml;
    exports org.example.keydetectiontest;
}