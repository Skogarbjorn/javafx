module org.example.kubburredo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.kubburredo to javafx.fxml;
    exports org.example.kubburredo;
}