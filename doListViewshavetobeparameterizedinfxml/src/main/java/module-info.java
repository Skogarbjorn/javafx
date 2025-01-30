module org.example.dolistviewshavetobeparameterizedinfxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.dolistviewshavetobeparameterizedinfxml to javafx.fxml;
    exports org.example.dolistviewshavetobeparameterizedinfxml;
}