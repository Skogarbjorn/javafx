module org.example.strengirredo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.strengirredo to javafx.fxml;
    exports org.example.strengirredo;
}