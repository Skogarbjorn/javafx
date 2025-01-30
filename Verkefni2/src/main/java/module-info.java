module org.example.verkefni2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.verkefni2 to javafx.fxml;
    exports org.example.verkefni2;
}