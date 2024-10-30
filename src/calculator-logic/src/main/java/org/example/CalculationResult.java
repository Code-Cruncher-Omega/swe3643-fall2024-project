package org.example;

public class CalculationResult {
    private double result;
    private boolean isSuccess;
    private String operation;
    private String error;

    public CalculationResult(double result, boolean isSuccess, String operation, String error) {
        this.result = result;
        this.isSuccess = isSuccess;
        this.operation = operation;
        this.error = error;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
