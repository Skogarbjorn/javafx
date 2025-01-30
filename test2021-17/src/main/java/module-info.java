module org.example.test202117 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.test202117 to javafx.fxml;
    exports org.example.test202117;
}