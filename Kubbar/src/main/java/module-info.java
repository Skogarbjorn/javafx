module org.example.kubbar {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.kubbar to javafx.fxml;
    exports org.example.kubbar;
}