module org.example.dinosaurgametest {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.dinosaurgametest to javafx.fxml;
    opens rafmagn to javafx.fxml;
    opens snua to javafx.fxml;
    exports org.example.dinosaurgametest;
    exports test;
    exports comboBoxTest;
    exports datePickerTest;
    exports rafmagn;
    exports snua;
}
