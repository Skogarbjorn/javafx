module org.example.verkefni2real {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.verkefni2real to javafx.fxml;
    exports org.example.verkefni2real;
}