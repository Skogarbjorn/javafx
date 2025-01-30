module org.example.listviewtest {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.listviewtest to javafx.fxml;
    exports org.example.listviewtest;
}