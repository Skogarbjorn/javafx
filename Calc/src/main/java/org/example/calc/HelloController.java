package org.example.calc;

import computing.Numbers;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HelloController {
    @FXML
    private Label screen;
    @FXML
    private Label ghostScreen;
    private final Numbers gamer = new Numbers();
    private Scene scene;
    @FXML
    private Button enter;

    public void setScene(Scene scene) {
        this.scene = scene;
        enter.requestFocus();
    }

    @FXML
    protected void oneButtonClick() {
        gamer.setStoredNumber("1");
        setScreen(gamer.getStoredNumber());
    }
    @FXML
    protected void twoButtonClick() {
        gamer.setStoredNumber("2");
        setScreen(gamer.getStoredNumber());
    }
    @FXML
    protected void threeButtonClick() {
        gamer.setStoredNumber("3");
        setScreen(gamer.getStoredNumber());
    }
    @FXML
    protected void fourButtonClick() {
        gamer.setStoredNumber("4");
        setScreen(gamer.getStoredNumber());
    }
    @FXML
    protected void fiveButtonClick() {
        gamer.setStoredNumber("5");
        setScreen(gamer.getStoredNumber());
    }
    @FXML
    protected void sixButtonClick() {
        gamer.setStoredNumber("6");
        setScreen(gamer.getStoredNumber());
    }
    @FXML
    protected void sevenButtonClick() {
        gamer.setStoredNumber("7");
        setScreen(gamer.getStoredNumber());
    }
    @FXML
    protected void eightButtonClick() {
        gamer.setStoredNumber("8");
        setScreen(gamer.getStoredNumber());
    }
    @FXML
    protected void nineButtonClick() {
        gamer.setStoredNumber("9");
        setScreen(gamer.getStoredNumber());
    }
    @FXML
    protected void zeroButtonClick() {
        gamer.setStoredNumber("0");
        setScreen(gamer.getStoredNumber());
    }
    @FXML
    protected void dotButtonClick() {
        gamer.setStoredNumber(".");
        setScreen(gamer.getStoredNumber());
    }
    @FXML
    protected void negativeButtonClick() {
        gamer.setStoredNumber("-");
        setScreen(gamer.getStoredNumber());
    }
    @FXML
    protected void backspaceButtonClick() {
        try {
            gamer.removeNumber();
            setScreen(gamer.getStoredNumber());
        } catch (NullPointerException ignored){}
    }

    @FXML
    protected void plusButtonClick() {
        ghostScreen.setText(gamer.getStoredNumber() + " +");
        setScreen("");
        gamer.plus();
    }
    @FXML
    protected void minusButtonClick() {
        ghostScreen.setText(gamer.getStoredNumber() + " -");
        setScreen("");
        gamer.minus();
    }
    @FXML
    protected void multiplyButtonClick() {
        ghostScreen.setText(gamer.getStoredNumber() + " *");
        setScreen("");
        gamer.multiply();
    }
    @FXML
    protected void divideButtonClick() {
        ghostScreen.setText(gamer.getStoredNumber() + " /");
        setScreen("");
        gamer.divide();
    }
    @FXML
    protected void powerButtonClick() {
        ghostScreen.setText(gamer.getStoredNumber() + " ^");
        setScreen("");
        gamer.power();
    }
    @FXML
    protected void enterButtonClick() {
        try {
            setScreen(gamer.enter());
            ghostScreen.setText("");
        } catch (ArithmeticException ex) {
            setScreen("MATH ERROR");
        }
    }

    @FXML
    protected void clearButtonClick() {
        gamer.clear();
        setScreen("");
        ghostScreen.setText("");
    }

    @FXML
    public void setScreen(String x) {
        screen.setText(x);
    }

    public void handleKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            enterButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.DELETE)) {
            clearButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.BACK_SPACE)) {
            backspaceButtonClick();
        }
        else if (keyEvent.getCode() == KeyCode.EQUALS && keyEvent.isShiftDown() || keyEvent.getCode() == KeyCode.ADD) {
            plusButtonClick();
        }
        else if (keyEvent.getCode() == KeyCode.MINUS || keyEvent.getCode() == KeyCode.SUBTRACT) {
            if (gamer.getStoredNumber().isEmpty()) {
                negativeButtonClick();
            }
            else {
                minusButtonClick();
            }
        }
        else if (keyEvent.getCode().equals(KeyCode.DIGIT8) && keyEvent.isShiftDown() || keyEvent.getCode() == KeyCode.MULTIPLY) {
            multiplyButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.SLASH) || keyEvent.getCode() == KeyCode.DIVIDE) {
            divideButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.DIGIT6) && keyEvent.isShiftDown()) {
            powerButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.PERIOD) || keyEvent.getCode() == KeyCode.COMMA || keyEvent.getCode() == KeyCode.DECIMAL) {
            dotButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.DIGIT1) || keyEvent.getCode().equals(KeyCode.NUMPAD1)) {
            oneButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.DIGIT2) || keyEvent.getCode().equals(KeyCode.NUMPAD2)) {
            twoButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.DIGIT3) || keyEvent.getCode().equals(KeyCode.NUMPAD3)) {
            threeButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.DIGIT4) || keyEvent.getCode().equals(KeyCode.NUMPAD4)) {
            fourButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.DIGIT5) || keyEvent.getCode().equals(KeyCode.NUMPAD5)) {
            fiveButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.DIGIT6) || keyEvent.getCode().equals(KeyCode.NUMPAD6)) {
            sixButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.DIGIT7) || keyEvent.getCode().equals(KeyCode.NUMPAD7)) {
            sevenButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.DIGIT8) || keyEvent.getCode().equals(KeyCode.NUMPAD8)) {
            eightButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.DIGIT9) || keyEvent.getCode().equals(KeyCode.NUMPAD9)) {
            nineButtonClick();
        }
        else if (keyEvent.getCode().equals(KeyCode.DIGIT0) || keyEvent.getCode().equals(KeyCode.NUMPAD0)) {
            zeroButtonClick();
        }
        enter.requestFocus();
    }
}
