package org.example.goodcalc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import logic.*;
import logic.operations.*;

import java.util.ArrayList;

public class Controller {
    @FXML
    private Label screen;
    @FXML
    private Label resultScreen;

    @FXML
    private void updateScreen(ArrayList<Object> list) {
        System.out.println("super" + Formatting.getOperationsList());
        screen.setText(Printing.printer(list));
    }


    @FXML
    private void updateResult(double a) {
        resultScreen.setText(Double.toString(a));
    }

    @FXML
    protected void one() {
        CurrentNumber.addToString("1");
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void two() {
        CurrentNumber.addToString("2");
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void three() {
        CurrentNumber.addToString("3");
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void four() {
        CurrentNumber.addToString("4");
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void five() {
        CurrentNumber.addToString("5");
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void six() {
        CurrentNumber.addToString("6");
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void seven() {
        CurrentNumber.addToString("7");
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void eight() {
        CurrentNumber.addToString("8");
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void nine() {
        CurrentNumber.addToString("9");
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void zero() {
        CurrentNumber.addToString("0");
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void dot() {
        CurrentNumber.addToString(".");
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void exp() {
        CurrentNumber.addToString("e");
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void ans() {

    }

    @FXML
    protected void equals() {
        try {
            CurrentNumber.finalizeNumber();
            Position.last();
            Calculation calculation = new Calculation(Formatting.getOperationsList());
            calculation.proxyConverter();
            updateScreen(Formatting.getOperationsList());
            updateResult(calculation.getResult());
        } catch (NullPointerException ex) {
            Calculation calculation = new Calculation(Formatting.getOperationsList());
            calculation.proxyConverter();
            updateScreen(Formatting.getOperationsList());
            updateResult(calculation.getResult());
        }
    }

    @FXML
    protected void add() {
        try {
            CurrentNumber.finalizeNumber();
            Formatting.addOperationToList(new Add());
            updateScreen(Formatting.getOperationsList());
        } catch (NullPointerException ex) {
            Formatting.addOperationToList(new Add());
            updateScreen(Formatting.getOperationsList());
        }
    }

    @FXML
    protected void subtract() {
        try {
            if (CurrentNumber.peek() == 'e') {
                CurrentNumber.addToString("-");
            } else {
                CurrentNumber.finalizeNumber();
                Formatting.addOperationToList(new Subtract());
                updateScreen(Formatting.getOperationsList());
            }
        } catch (NullPointerException ex) {
            Formatting.addOperationToList(new Subtract());
            updateScreen(Formatting.getOperationsList());
        }
    }

    @FXML
    protected void multiply() {
        try {
            CurrentNumber.finalizeNumber();
            Formatting.addOperationToList(new Multiply());
            updateScreen(Formatting.getOperationsList());
        } catch (NullPointerException ex) {
            Formatting.addOperationToList(new Multiply());
            updateScreen(Formatting.getOperationsList());
        }
    }

    @FXML
    protected void divide() {
        try {
            CurrentNumber.finalizeNumber();
            Formatting.addOperationToList(new Divide());
            updateScreen(Formatting.getOperationsList());
        } catch (NullPointerException ex) {
            Formatting.addOperationToList(new Divide());
            updateScreen(Formatting.getOperationsList());
        }
    }

    @FXML
    protected void lpar() {
        try {
            CurrentNumber.finalizeNumber();
            Formatting.addOperationToList(new LPar());
            updateScreen(Formatting.getOperationsList());
        } catch (NullPointerException ex) {
            Formatting.addOperationToList(new LPar());
            updateScreen(Formatting.getOperationsList());
        }
    }

    @FXML
    protected void rpar() {
        try {
            CurrentNumber.finalizeNumber();
            Formatting.addOperationToList(new RPar());
            updateScreen(Formatting.getOperationsList());
        } catch (NullPointerException ex) {
            Formatting.addOperationToList(new RPar());
            updateScreen(Formatting.getOperationsList());
        }
    }

    @FXML
    protected void left() {
        Position.left();
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void right() {
        Position.right();
        updateScreen(Formatting.getOperationsList());
    }

    @FXML
    protected void delete() {
        try {
            if (CurrentNumber.isEmpty()) {
                if (Formatting.getOperationsList().get(Position.index-1).getClass().equals(Double.class)) {
                    System.out.println("wooohooo");
                    CurrentNumber.first = false;
                    CurrentNumber.setString(Formatting.getOperationsList().get(Position.index-1).toString());
                    CurrentNumber.removeFromString();
                    CurrentNumber.updateNumber();
                } else {
                    Formatting.removeFromList();
                    updateScreen(Formatting.getOperationsList());
                }
            } else {
                CurrentNumber.removeFromString();
            }
            updateScreen(Formatting.getOperationsList());
        } catch (NullPointerException ignore){}
        catch (IndexOutOfBoundsException ex) {
            Formatting.removeFromList();
            updateScreen(Formatting.getOperationsList());
        }
    }

    @FXML
    protected void clear() {
        Formatting.clear();
        CurrentNumber.clear();
        Position.clear();
        screen.setText("");
        resultScreen.setText("");
    }
}
