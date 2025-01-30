module org.example.calc {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.calc to javafx.fxml;
    exports org.example.calc;
}