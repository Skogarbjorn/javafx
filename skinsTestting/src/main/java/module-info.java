module org.example.skinstestting {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.skinstestting to javafx.fxml;
    exports org.example.skinstestting;
}