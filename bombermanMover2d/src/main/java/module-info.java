module org.example.bombermanmover2d {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.bombermanmover2d to javafx.fxml;
    exports org.example.bombermanmover2d;
}