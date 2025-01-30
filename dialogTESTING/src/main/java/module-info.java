module org.example.dialogtesting {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.dialogtesting to javafx.fxml;
    exports org.example.dialogtesting;
}