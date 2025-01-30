package logic;


import logic.operations.*;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    private ArrayList<Object> operations;
    private double result;

    public Calculation(ArrayList<Object> operationsList) {
        this.operations = operationsList;
    }

    public void proxyConverter() {
        this.operations.add(null);
        this.result = calculation(this.operations.subList(0, this.operations.size()-1));
    }

    public double getResult() {
        uncertaintyChecker();
        return result;
    }

    public double calculation(List<Object> operationsList) {
        System.out.println(operationsList);
        LPar lpar;
        boolean isParenthesis = true;
        boolean isMultiply = true;
        boolean isDivide = true;
        boolean isAdd = true;
        boolean isSubtract = true;

        while (isParenthesis) {
            isParenthesis = false;
            for (int leftIndex = 0; leftIndex < operationsList.size(); leftIndex++) {
                if (operationsList.get(leftIndex).getClass().equals(LPar.class)) {
                    int rightIndex = search(leftIndex, operationsList);
                    List<Object> operationsListCut = operationsList.subList(leftIndex + 1, rightIndex);
                    System.out.println(operationsListCut);
                    System.out.println(operationsList);
                    calculation(operationsListCut);
                    operationsList.remove(leftIndex+2);
                    operationsList.remove(leftIndex);
                    System.out.println(operationsList);
                    isParenthesis = true;
                }
            }
        }
        while (isMultiply) {
            isMultiply = false;
            for (int i = 0; i < operationsList.size(); i++) {
                if (operationsList.get(i).getClass().equals(Multiply.class)) {
                    double result = Double.parseDouble(operationsList.get(i-1).toString()) * Double.parseDouble(operationsList.get(i+1).toString());
                    operationsList.subList(i-1, i+2).clear();
                    operationsList.add(i-1, result);
                    isMultiply = true;
                }
            }
        }
        while (isDivide) {
            isDivide = false;
            for (int i = 0; i < operationsList.size(); i++) {
                if (operationsList.get(i).getClass().equals(Divide.class)) {
                    double result = Double.parseDouble(operationsList.get(i-1).toString()) / Double.parseDouble(operationsList.get(i+1).toString());
                    operationsList.subList(i-1, i+2).clear();
                    operationsList.add(i-1, result);
                    isDivide = true;
                }
            }
        }
        while (isSubtract) {
            isSubtract = false;
            for (int i = 0; i < operationsList.size(); i++) {
                if (operationsList.get(i).getClass().equals(Subtract.class)) {
                    double result = Double.parseDouble(operationsList.get(i-1).toString()) - Double.parseDouble(operationsList.get(i+1).toString());
                    operationsList.subList(i-1, i+2).clear();
                    operationsList.add(i-1, result);
                    isSubtract = true;
                }
            }
        }
        while (isAdd) {
            isAdd = false;
            for (int i = 0; i < operationsList.size(); i++) {
                if (operationsList.get(i).getClass().equals(Add.class)) {
                    double result = Double.parseDouble(operationsList.get(i-1).toString()) + Double.parseDouble(operationsList.get(i+1).toString());
                    operationsList.subList(i-1, i+2).clear();
                    operationsList.add(i-1, result);
                    isAdd = true;
                }
            }
        }
        System.out.println(Double.parseDouble(operationsList.get(0).toString()));
        return Double.parseDouble(operationsList.get(0).toString());
    }

    private int search(int leftIndex, List<Object> operationsList) {
        int count = 1;
        leftIndex++;
        while (count != 0 && leftIndex != operationsList.size()) {
            if (operationsList.get(leftIndex).getClass().equals(LPar.class)) count++;
            if (operationsList.get(leftIndex).getClass().equals(RPar.class)) count--;
            leftIndex++;
        }
        return --leftIndex;
    }

    public void uncertaintyChecker() {
        if (Math.abs((int) result - result) < 1e-14) {
            result = (int) result;
        }
    }
}

