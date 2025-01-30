module org.example.kubbur {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.kubbur to javafx.fxml;
    exports org.example.kubbur;
}