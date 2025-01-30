package org.example.kubbar;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import vinnsla.Kubbur;
import vinnsla.Stykki;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private TextField input;
    @FXML
    private Label points;
    private final Stykki stykki = new Stykki();
    private boolean isDisabled = false;
    private int youWin = 0;

    public void initialize() {
        input.setOnKeyPressed(e -> userInputHandler(e));
    }

    @FXML
    protected void onButtonClick(Button button) {
        if (!isDisabled) {
            stykki.makeRandom();
            button.setText(Integer.toString(stykki.getCurrentRandom()));
            if (Kubbur.isEqual(stykki.getCurrentRandom())) {
                updatePoints(Kubbur.getPoints());
                disable();
                button.setDisable(true);
                input.requestFocus();
                if (++youWin == 1) youWin();
            }
            Kubbur.minus();
        }
    }

    protected void updatePoints(String points) {
        this.points.setText(points);
    }

    @FXML
    protected void onOneButtonClick() {onButtonClick(one);}
    @FXML
    protected void onTwoButtonClick() {onButtonClick(two);}
    @FXML
    protected void onThreeButtonClick() {onButtonClick(three);}
    @FXML
    protected void onFourButtonClick() {onButtonClick(four);}
    @FXML
    protected void onFiveButtonClick() {onButtonClick(five);}
    @FXML
    protected void onSixButtonClick() {onButtonClick(six);}
    @FXML
    protected void onSevenButtonClick() {onButtonClick(seven);}
    @FXML
    protected void onEightButtonClick() {onButtonClick(eight);}
    @FXML
    protected void onNineButtonClick() {onButtonClick(nine);}

    protected void disable() {
        isDisabled = true;
    }

    protected void enable() {
        isDisabled = false;
    }

    protected void cleanse() {
        if (!one.isDisabled()) one.setText(null);
        if (!two.isDisabled()) two.setText(null);
        if (!three.isDisabled()) three.setText(null);
        if (!four.isDisabled()) four.setText(null);
        if (!five.isDisabled()) five.setText(null);
        if (!six.isDisabled()) six.setText(null);
        if (!seven.isDisabled()) seven.setText(null);
        if (!eight.isDisabled()) eight.setText(null);
        if (!nine.isDisabled()) nine.setText(null);
    }

    protected void reset() {
        enable();
        one.setDisable(false);
        one.setText("");
        two.setDisable(false);
        two.setText("");
        three.setDisable(false);
        three.setText("");
        four.setDisable(false);
        four.setText("");
        five.setDisable(false);
        five.setText("");
        six.setDisable(false);
        six.setText("");
        seven.setDisable(false);
        seven.setText("");
        eight.setDisable(false);
        eight.setText("");
        nine.setDisable(false);
        nine.setText("");
        updatePoints("0");
        Kubbur.reset();
        Kubbur.resetPoints();
        youWin=0;
        input.setText("");
        input.requestFocus();
    }

    private void youWin() {
        try {
            FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("youwin.fxml"));
            Stage stage2 = new Stage();
            Scene scene2 = new Scene(fxmlLoader2.load(), 500, 300);
            stage2.setTitle("Hello!");
            stage2.setScene(scene2);
            stage2.show();
            WinController.setController(this);
            System.out.println("gmare");
        } catch (IOException ignored){}
    }


    protected void userInputHandler(KeyEvent e) {
        try {
            Kubbur.setInput(e);
            enable();
            cleanse();
            Kubbur.resetPoints();
        } catch (NumberFormatException ignored){}
    }
}
