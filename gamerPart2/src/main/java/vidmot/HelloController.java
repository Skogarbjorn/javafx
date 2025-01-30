package vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView myImageView;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 17) );
        welcomeText.setTextFill(Color.RED);
        welcomeText.setText("Halló Ragnar.");
        myImageView.setOpacity(0.7);
    }
}
