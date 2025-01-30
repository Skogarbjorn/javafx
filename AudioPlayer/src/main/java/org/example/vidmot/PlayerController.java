package org.example.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import vinnsla.Askrifandi;
import vinnsla.Lagalistar;

import java.util.Optional;

/**
 * Controller klasi fyrir heima-view.fxml
 */
public class PlayerController {
    @FXML
    private Button loginButton;

    @FXML
    private GridPane listaGrid;

    private static boolean isLoggedIn = false;

    private static String loginName = "Login";

    /**
     * Höndlar þegar notandi ýtir á login takka og opnar nýtt AskrifandiDialog
     */
    @FXML
    private void onLogin() {
        AskrifandiDialog dialog = new AskrifandiDialog();

        Optional<Askrifandi> result = dialog.showAndWait();
        if (result.isPresent()) {
            Askrifandi askrifandi = result.get();
            loginButton.setText(askrifandi.getNafn());
            loginName = askrifandi.getNafn();
            listaGrid.setDisable(false);
            isLoggedIn = true;
        }
    }

    /**
     * Höndlar þegar notandi velur lista-takka og skiptir um lista sem Lagalistar notar
     * @param actionEvent actionEventið sem notandi notaði til að ýta á takkann
     */
    @FXML
    private void onVeljaLista(ActionEvent actionEvent) {
        Node button = (Node) actionEvent.getSource();
        int index = GridPane.getRowIndex(button)*listaGrid.getRowCount() + GridPane.getColumnIndex(button);
        Lagalistar.setIndex(index);
        ViewSwitcher.setScene(loginButton.getScene());
        ViewSwitcher.switchTo(View.LISTAR);
    }

    /**
     * Initialize fall
     */
    public void initialize() {
        int counter = 0;
        if (isLoggedIn) listaGrid.setDisable(false);
        loginButton.setText(loginName);
        for (Node node : listaGrid.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                ImageView albumCover = (ImageView) button.getGraphic();
                if (counter < Lagalistar.getLength()) {
                    Lagalistar.setIndex(counter);
                    albumCover.setImage(Lagalistar.getLagalisti().getAlbumCover());
                }
                counter++;
            }
        }
    }
}
