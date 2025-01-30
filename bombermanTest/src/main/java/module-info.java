module org.example.bombermantest {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.bombermantest to javafx.fxml;
    exports org.example.bombermantest;
}