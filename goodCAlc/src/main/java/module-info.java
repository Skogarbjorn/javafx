module org.example.goodcalc {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.goodcalc to javafx.fxml;
    exports org.example.goodcalc;
}