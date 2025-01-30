package rafmagn;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RafmagnController {
    // tilviksbreytur
    @FXML
    private TextField fxVerd;
    @FXML
    private Label fxKostnadur;
    @FXML
    private TextField fxEknir;
    @FXML
    private TextField fxRafmagn;
    @FXML
    private Label fxEydsla;

    // aðferðir
    @FXML
    public void onReiknaKostnad(ActionEvent actionEvent) {
        String rafmagn = fxRafmagn.getText();
        String verd = fxVerd.getText();

        if (rafmagn != null && verd != null) {
            try {
                fxKostnadur.setText(Double.toString(Double.parseDouble(rafmagn) * Double.parseDouble(verd)));
            } catch (NumberFormatException ex) {
                fxKostnadur.setText("0");
            }
        }
    }

    public void initialize() {
        fxEydsla.textProperty().bind(Bindings.createStringBinding(() -> {
            String eknir = fxEknir.getText();
            String rafmagn = fxRafmagn.getText();

            if (eknir != null && rafmagn != null && !rafmagn.equals("0")) {
                try {
                    return String.valueOf(Double.parseDouble(rafmagn) / Double.parseDouble(eknir));
                } catch (NumberFormatException ex) {
                    return "0";
                }
            }
            return "0";

        }, fxEknir.textProperty(), fxRafmagn.textProperty()));
    }
}
