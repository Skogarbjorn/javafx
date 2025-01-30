module org.example.rotationtest {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.rotationtest to javafx.fxml;
    exports org.example.rotationtest;
}