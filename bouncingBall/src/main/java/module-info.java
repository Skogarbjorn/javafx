module org.example.bouncingball {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.bouncingball to javafx.fxml;
    exports org.example.bouncingball;
}