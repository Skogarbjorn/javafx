module org.example.goldrushredo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.goldrushredo to javafx.fxml;
    exports org.example.goldrushredo;
}