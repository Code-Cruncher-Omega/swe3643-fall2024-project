package org.example.model;

import org.example.CalculatorLogic;
import org.example.Interpreter;

public class AppModel {

    private String values;
    private String operation;
    private boolean isError;

    public AppModel(String values, String operation, boolean isError) {
        this.values = values;
        this.operation = operation;
        this.isError = isError;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public void calculateData() {

        if(operation.equals("-1")) {
            operation = "Enter values below, then select an operation";
            values = "";
            return;
        }

        String[] stringList;
        double[] doubleList;
        boolean comma = false;
        boolean newLine = false;

        if(operation.equals("0")) {
            newLine = true;
        } else if(operation.equals("1")) {
            newLine = true;
        } else if(operation.equals("2")) {
            newLine = true;
        } else if(operation.equals("3")) {
            comma = true;
        } else if(operation.equals("4")) {
            newLine = true;
            comma = true;
        } else {
            comma = true;
        }

        try {
            stringList = Interpreter.splitString(values, comma, newLine);
        }   catch (Exception e) {
            operation = e.getMessage();
            isError = true;
            return;
        }
        try {
            doubleList = Interpreter.parseStringArrayToDoubleArray(stringList);
        }   catch (Exception e) {
            operation = e.getMessage();
            isError = true;
            return;
        }
        try {
            if(operation.equals("0")) {
                operation = "Compute Sample Standard Deviation\n" + CalculatorLogic.computeSampleStandardDeviation(doubleList);
            } else if(operation.equals("1")) {
                operation = "Compute Population Standard Deviation\n" + CalculatorLogic.computePopulationStandardDeviation(doubleList);
            } else if(operation.equals("2")) {
                operation = "Compute Mean\n" + CalculatorLogic.computeMean(doubleList);
            } else if(operation.equals("3")) {
                operation = "Compute Z Score\n" + CalculatorLogic.computeZScore(doubleList);
            } else if(operation.equals("4")) {
                double[] slrf = CalculatorLogic.computeSingleLineRegressionFormula(doubleList);
                operation = "Compute Single Linear Regression Formula\ny = " + slrf[0] + "x + " + slrf[1];
            } else {
                operation = "Single Linear Regression Prediction\ny = " + CalculatorLogic.predictYFromLinearRegressionFormula(doubleList);
            }
        } catch(Exception e) {
            operation = e.getMessage();
            isError = true;
            return;
        }
        isError = false;
    }
}
