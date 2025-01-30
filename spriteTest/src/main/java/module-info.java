module org.example.spritetest {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.spritetest to javafx.fxml;
    exports org.example.spritetest;
}